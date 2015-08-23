package com.mygrator.cassandra.migrator;

import com.datastax.driver.core.Session;
import com.mygrator.exception.MigrationException;
import com.mygrator.migrator.AbstractClasspathFileMigrator;
import com.mygrator.migrator.ClassMigrater;

public class CassandraClassPathFileMigrator extends AbstractClasspathFileMigrator<Session> implements ClassMigrater<Session> {

	public CassandraClassPathFileMigrator(String resource) {
		super(resource);
	}

	@Override
	public void doMigration(Session session) throws MigrationException {
		
		String script = super.getScript();
		
		session.execute(script);
		
	}

	

}
