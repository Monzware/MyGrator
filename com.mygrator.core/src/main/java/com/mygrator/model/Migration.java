package com.mygrator.model;

import java.util.Calendar;

public interface Migration {
	
	MigrationKey getKey();
	
	MigrationVersion getVersion();
	
	String getDescription();
	
	MigrationType getType();
	
	String getMigratorName();
	
	String getChecksum();
	
	String getMigrationUserID();
	
	String getMigrationUserName();
	
	Calendar getMigrationTime();
	
	int getExecutionTime();
	
	MigrationStatus getMigrationStatus();
	
	String getMigrationLog();

}
