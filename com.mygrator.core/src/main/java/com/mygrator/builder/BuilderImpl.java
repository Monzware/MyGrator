package com.mygrator.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ServiceLoader;

import com.mygrator.MyGrator;
import com.mygrator.exception.MissingMigratorException;
import com.mygrator.migrator.MigrationProvider;
import com.mygrator.provider.ResourceProvider;
import com.mygrator.service.MyGratorService;

public class BuilderImpl implements Builder {

	private ResourceProvider<?> resourceProvider;
	private String userName;
	private String historyName;
	private Collection<MigrationProvider<?>> migrationProviders = new ArrayList<>();

	@Override
	public Builder setResourceProvider(ResourceProvider<?> resourceProvider) {
		this.resourceProvider = resourceProvider;
		return this;
	}

	@Override
	public Builder setHistoryStoreName(String historyName) {
		this.historyName = historyName;
		return this;
	}

	@Override
	public MyGrator build() throws MissingMigratorException {
		
		@SuppressWarnings("rawtypes")
		ServiceLoader<MyGratorService> loader = ServiceLoader.load(MyGratorService.class);
		for (MyGratorService<?> myGratorService : loader) {
			if (myGratorService.accept(resourceProvider)) {
				return new MyGrator(myGratorService, userName, historyName, resourceProvider, migrationProviders);
			}
		}
		
		throw new MissingMigratorException();
		
	}

	@Override
	public Builder setUser(String userName) {
		this.userName = userName;
		
		return this;
	}

	@Override
	public Builder addMigrationProvider(MigrationProvider<?> migrationProvider) {
		migrationProviders.add(migrationProvider);
		return this;
	}

}