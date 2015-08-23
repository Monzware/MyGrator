package com.mygrator.service;

import java.util.Collection;

import com.mygrator.migrator.ClassMigrater;
import com.mygrator.model.Migration;
import com.mygrator.provider.ResourceProvider;

public interface MyGratorService<T> {

	boolean accept(ResourceProvider<?> resourceProvider);

	Collection<Migration> getMigrationHistory();
	
	void setMigrationStatus(Migration migration);
	
	ClassMigrater<T> createMigrationClassFromScript(String scriptName, String script);

}
