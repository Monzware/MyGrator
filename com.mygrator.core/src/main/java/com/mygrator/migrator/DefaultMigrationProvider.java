package com.mygrator.migrator;

import java.util.ArrayList;
import java.util.Collection;

public class DefaultMigrationProvider<T> implements MigrationProvider<T> {
	
	Collection<ClassMigrater<T>> migraters = new ArrayList<>();

	public DefaultMigrationProvider<T> addMigratorClass(Class<ClassMigrater<T>> migratorClass) {
		
		return this;
	}

	public DefaultMigrationProvider<T> addMigratorResource(String resource) {
		
		return this;
	}

	public DefaultMigrationProvider<T> addMigrator(ClassMigrater<T> migrator) {
		migraters.add(migrator);
		return this;
		
	}

	@Override
	public Collection<ClassMigrater<T>> getMigrations() {
		// TODO Auto-generated method stub
		return migraters;
	}


}
