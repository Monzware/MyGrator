package com.mygrator.cassandra.migrator;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.datastax.driver.core.Session;
import com.mygrator.exception.MigrationException;
import com.mygrator.migrator.ClassMigrater;

public class CassandraStreamScriptMigrator implements ClassMigrater<Session> {

	private InputStream scriptInputStream;

	public CassandraStreamScriptMigrator(String scriptName, InputStream scriptInputStream) {
		this.scriptInputStream = scriptInputStream;
	}

	@Override
	public void doMigration(Session session) throws MigrationException {
		try {
			String script = IOUtils.toString(scriptInputStream, "UTF-8");
			session.execute(script);
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}
