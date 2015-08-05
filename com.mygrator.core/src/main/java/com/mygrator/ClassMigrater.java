package com.mygrator;

public interface ClassMigrater<T> {
	
	void doMigration(T resource) throws MigrationException;

}
