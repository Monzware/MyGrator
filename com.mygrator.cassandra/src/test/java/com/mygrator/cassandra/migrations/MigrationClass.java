package com.mygrator.cassandra.migrations;

import com.datastax.driver.core.Session;
import com.mygrator.ClassMigrater;
import com.mygrator.MigrationException;

public class MigrationClass implements ClassMigrater<Session> {

	@Override
	public void doMigration(Session session) throws MigrationException {
		
		
		//Do something on session. Alter data
		//session.execute()
		
		
		
	}
	
	

}
