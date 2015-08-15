package com.mygrator;

import java.io.Closeable;
import java.util.Collection;
import java.util.List;

import com.mygrator.builder.Builder;
import com.mygrator.builder.BuilderImpl;
import com.mygrator.migrator.MigrationProvider;
import com.mygrator.model.Migration;
import com.mygrator.model.MigrationResult;
import com.mygrator.provider.ResourceProvider;
import com.mygrator.service.MyGratorService;

public class MyGrator implements Closeable {
	
	
	private MyGratorService<?> service;
	private String userName;
	private String historyName;
	private ResourceProvider<?> resourceProvider;
	private Collection<MigrationProvider<?>> migrationProviders;

	public MyGrator(MyGratorService<?> myGratorService, String userName, String historyName,
			ResourceProvider<?> resourceProvider, Collection<MigrationProvider<?>> migrationProviders) {
				this.service = myGratorService;
				this.userName = userName;
				this.historyName = historyName;
				this.resourceProvider = resourceProvider;
				this.migrationProviders = migrationProviders;
	}

	public static Builder builder() {
        return new BuilderImpl();
    }

	public void initialize() {
		
		for (MigrationProvider<?> migrationProvider : migrationProviders) {
			
			
			
		}
		
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
