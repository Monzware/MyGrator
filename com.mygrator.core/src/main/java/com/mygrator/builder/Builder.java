package com.mygrator.builder;

import com.mygrator.MyGrator;
import com.mygrator.exception.MissingMigratorException;
import com.mygrator.migrator.MigrationProvider;
import com.mygrator.provider.ResourceProvider;

public interface Builder<T> {

	Builder<T> setResourceProvider(ResourceProvider<T> resourceProvider);

	Builder<T> setHistoryStoreName(String historyName);

	MyGrator<T> build() throws MissingMigratorException;

	Builder<T> setUser(String userName);

	Builder<T> addMigrationProvider(MigrationProvider<T> migrationProvider);

}
