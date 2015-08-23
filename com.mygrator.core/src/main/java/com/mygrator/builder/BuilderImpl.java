package com.mygrator.builder;

import java.util.ServiceLoader;

import com.mygrator.MyGrator;
import com.mygrator.exception.MissingMigratorException;
import com.mygrator.migrator.MigrationProvider;
import com.mygrator.provider.ResourceProvider;
import com.mygrator.service.MyGratorService;

public class BuilderImpl<T> implements Builder<T> {

	private ResourceProvider<T> resourceProvider;
	private String userName;
	private String historyName;
	private MigrationProvider<T> migrationProvider;

	@Override
	public Builder<T> setResourceProvider(ResourceProvider<T> resourceProvider) {
		this.resourceProvider = resourceProvider;
		return this;
	}

	@Override
	public Builder<T> setHistoryStoreName(String historyName) {
		this.historyName = historyName;
		return this;
	}

	@Override
	public MyGrator<T> build() throws MissingMigratorException {
		
		@SuppressWarnings("rawtypes")
		ServiceLoader<MyGratorService> loader = ServiceLoader.load(MyGratorService.class);
		for (MyGratorService<T> myGratorService : loader) {
			if (myGratorService.accept(resourceProvider)) {
				return new MyGrator<T>(myGratorService, userName, historyName, resourceProvider, migrationProvider);
			}
		}
		
		throw new MissingMigratorException();
		
	}

	@Override
	public Builder<T> setUser(String userName) {
		this.userName = userName;
		
		return this;
	}

	@Override
	public Builder<T> addMigrationProvider(MigrationProvider<T> migrationProvider) {
		this.migrationProvider = migrationProvider;
		return this;
	}

}