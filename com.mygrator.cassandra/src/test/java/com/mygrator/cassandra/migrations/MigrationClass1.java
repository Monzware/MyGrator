package com.mygrator.cassandra.migrations;

import java.util.List;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.mygrator.exception.MigrationException;
import com.mygrator.migrator.ClassMigrater;

public class MigrationClass1 implements ClassMigrater<Session> {

	@Override
	public void doMigration(Session session) throws MigrationException {

		// Do something on session.
		ResultSet execute = session.execute("SELECT * FROM system.schema_keyspaces");
		List<Row> all = execute.all();
		System.out.println("Returned result set of " + all.size() + " rows");
	}
}
