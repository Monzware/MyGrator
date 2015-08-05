package com.mygrator;

public interface Builder {

	Builder setResourceProvider(ResourceProvider<?> resourceProvider);

	Builder addMigrationPackage(String packageName);

	Builder setHistoryStoreName(String historyName);

	MyGrator build() throws MissingMigratorException;

	Builder setUser(String userName);

}
