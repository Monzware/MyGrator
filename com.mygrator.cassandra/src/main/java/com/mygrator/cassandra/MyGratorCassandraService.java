package com.mygrator.cassandra;

import java.io.InputStream;
import java.util.Collection;

import com.datastax.driver.core.Session;
import com.mygrator.cassandra.migrator.CassandraStreamScriptMigrator;
import com.mygrator.migrator.ClassMigrater;
import com.mygrator.model.Migration;
import com.mygrator.provider.ResourceProvider;
import com.mygrator.service.MyGratorService;

public class MyGratorCassandraService implements MyGratorService<Session> {

	@Override
	public boolean accept(ResourceProvider<?> resourceProvider) {
		return resourceProvider.getResource().getClass().isAssignableFrom(Session.class);
	}

	@Override
	public Collection<Migration> getMigrationHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMigrationStatus(Migration migration) {
		
	}

	@Override
	public ClassMigrater<Session> createMigrationClassFromScript(String scriptName, InputStream script) {
		return new CassandraStreamScriptMigrator(scriptName, script);
	}
}
