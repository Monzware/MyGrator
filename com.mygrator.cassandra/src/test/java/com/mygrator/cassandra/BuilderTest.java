package com.mygrator.cassandra;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.datastax.driver.core.Session;
import com.mygrator.MigrationResult;
import com.mygrator.MissingMigratorException;
import com.mygrator.MyGrator;
import com.mygrator.ResourceProvider;

@RunWith(MockitoJUnitRunner.class)
public class BuilderTest implements ResourceProvider<Session> {
	
	@Mock
	Session session;

	@Test
	public void createBuilder() throws MissingMigratorException {

		MyGrator myGrator = MyGrator.builder().setResourceProvider(this)
				.addMigrationPackage("com.mygrator.cassandra.migrations").setUser("UserName")
				.setHistoryStoreName("databasemigration").build();

		myGrator.initialize();

		MigrationResult result = myGrator.migrateAll();

		myGrator.close();

	}

	@Override
	public Session getResource() {
		return session;
	}

	@Override
	public Class<Session> getProviderClass() {
		return Session.class;
	}

}
