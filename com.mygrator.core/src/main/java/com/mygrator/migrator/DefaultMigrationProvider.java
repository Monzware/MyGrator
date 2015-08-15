package com.mygrator.migrator;


public class DefaultMigrationProvider<T> implements MigrationProvider<T> {

	public DefaultMigrationProvider<T> addMigratorClass(Class<ClassMigrater<T>> migratorClass) {
		
		return this;
	}

	public DefaultMigrationProvider<T> addMigratorResource(String resource) {
		
		return this;
	}

	public DefaultMigrationProvider<T> addMigrator(ClassMigrater<T> migrator) {
		return this;
		
	}


}
