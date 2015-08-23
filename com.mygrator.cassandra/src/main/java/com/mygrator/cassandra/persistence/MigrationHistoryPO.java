package com.mygrator.cassandra.persistence;

import java.util.Calendar;

import com.datastax.driver.mapping.EnumType;
import com.datastax.driver.mapping.annotations.Enumerated;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;



@Table(name = MigrationHistoryPO.TABLE_NAME)


public class MigrationHistoryPO {

	public final static String TABLE_NAME = "migrationhistory"; 
	
	@PartitionKey
	private String key;	
	private String version;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private MigrationType type;
	private String migratorName;
	private String checksum;
	private String migrationUserID;
	private String migrationUserName;
	private Calendar migrationTime;
	private int executionTime;
	
	@Enumerated(EnumType.STRING)
	MigrationStatus getMigrationStatus;
	private String getMigrationLog;
	
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MigrationType getType() {
		return type;
	}
	public void setType(MigrationType type) {
		this.type = type;
	}
	public String getMigratorName() {
		return migratorName;
	}
	public void setMigratorName(String migratorName) {
		this.migratorName = migratorName;
	}
	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	public String getMigrationUserID() {
		return migrationUserID;
	}
	public void setMigrationUserID(String migrationUserID) {
		this.migrationUserID = migrationUserID;
	}
	public String getMigrationUserName() {
		return migrationUserName;
	}
	public void setMigrationUserName(String migrationUserName) {
		this.migrationUserName = migrationUserName;
	}
	public Calendar getMigrationTime() {
		return migrationTime;
	}
	public void setMigrationTime(Calendar migrationTime) {
		this.migrationTime = migrationTime;
	}
	public int getExecutionTime() {
		return executionTime;
	}
	public void setExecutionTime(int executionTime) {
		this.executionTime = executionTime;
	}
	public MigrationStatus getGetMigrationStatus() {
		return getMigrationStatus;
	}
	public void setGetMigrationStatus(MigrationStatus getMigrationStatus) {
		this.getMigrationStatus = getMigrationStatus;
	}
	public String getGetMigrationLog() {
		return getMigrationLog;
	}
	public void setGetMigrationLog(String getMigrationLog) {
		this.getMigrationLog = getMigrationLog;
	} 
}
    