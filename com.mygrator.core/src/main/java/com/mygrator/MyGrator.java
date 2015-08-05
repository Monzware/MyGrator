package com.mygrator;

import java.io.Closeable;
import java.util.List;

public class MyGrator implements Closeable {
	
	
	MyGrator(MyGratorService myGratorService, String userName) {
	}

	public static Builder builder() {
        return new BuilderImpl();
    }

	public void initialize() {
	}

	public List<Migration> getAllMigrations() {
		return null;
	}

	public List<Migration> getPendingMigrations() {
		return null;
	}

	public Migration getMigration(String id) {
		return null;
	}

	public MigrationResult migrateTo(Migration migration) {
		return null;
	}

	public MigrationResult migrateAll() {
		return null;
	}

	public void close() {
		
	}

}
