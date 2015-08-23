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

public class MyGrator<T> implements Closeable {
	
	
	private MyGratorService<T> service;
	private String userName;
	private String historyName;
	private ResourceProvider<T> resourceProvider;
	private MigrationProvider<T> migrationProvider;

	public MyGrator(MyGratorService<T> myGratorService, String userName, String historyName,
			ResourceProvider<T> resourceProvider, MigrationProvider<T> migrationProvider) {
				this.service = myGratorService;
				this.userName = userName;
				this.historyName = historyName;
				this.resourceProvider = resourceProvider;
				this.migrationProvider = migrationProvider;
	}

	public static <T> Builder<T> builder() {
        return new BuilderImpl<T>();
    }

	public static <T> Builder<T>  builder(Class<T> resourceClass) {
		return new BuilderImpl<T>();
	}
	
	public void initialize() {
		
		Object resource = resourceProvider.getResource();
				
		Collection<Migration> migrationHistory = service.getMigrationHistory();
		
		
		
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
