package com.mygrator;

import java.util.ServiceLoader;

class BuilderImpl implements Builder {

	private ResourceProvider<?> resourceProvider;
	private String userName;

	@Override
	public Builder setResourceProvider(ResourceProvider<?> resourceProvider) {
		this.resourceProvider = resourceProvider;
		return this;
	}

	@Override
	public Builder addMigrationPackage(String packageName) {
		return this;
	}

	@Override
	public Builder setHistoryStoreName(String historyName) {
		userName = historyName;
		return this;
	}

	@Override
	public MyGrator build() throws MissingMigratorException {

		ServiceLoader<MyGratorService> loader = ServiceLoader.load(MyGratorService.class);
		for (MyGratorService myGratorService : loader) {
			if (myGratorService.provides(resourceProvider.getProviderClass())) {
				return new MyGrator(myGratorService, userName);
			}
		}
		
		throw new MissingMigratorException();

	}

	@Override
	public Builder setUser(String userName) {
		this.userName = userName;
		return null;
	}

}
