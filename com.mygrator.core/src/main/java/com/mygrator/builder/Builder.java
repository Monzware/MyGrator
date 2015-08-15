package com.mygrator.builder;

import com.mygrator.MyGrator;
import com.mygrator.exception.MissingMigratorException;
import com.mygrator.migrator.MigrationProvider;
import com.mygrator.provider.ResourceProvider;

public interface Builder {

	Builder setResourceProvider(ResourceProvider<?> resourceProvider);

	Builder setHistoryStoreName(String historyName);

	MyGrator build() throws MissingMigratorException;

	Builder setUser(String userName);

	Builder addMigrationProvider(MigrationProvider<?> migrationProvider);

}
