package com.mygrator.migrator;

import com.mygrator.exception.MigrationException;

public interface ClassMigrater<T> {
	
	void doMigration(T resource) throws MigrationException;

}
