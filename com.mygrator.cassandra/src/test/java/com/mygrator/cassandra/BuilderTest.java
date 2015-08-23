package com.mygrator.cassandra;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.datastax.driver.core.Session;
import com.mygrator.MyGrator;
import com.mygrator.cassandra.migrations.MigrationClass1;
import com.mygrator.exception.MissingMigratorException;
import com.mygrator.migrator.DefaultMigrationProvider;
import com.mygrator.model.MigrationResult;
import com.mygrator.provider.ResourceProvider;

@RunWith(MockitoJUnitRunner.class)
public class BuilderTest implements ResourceProvider<Session> {
	
	@Mock
	Session session;

	@Test
	public void createBuilder() throws MissingMigratorException {
	
		DefaultMigrationProvider<Session> migrationProvider = new DefaultMigrationProvider<Session>();
		migrationProvider.addMigrator(new MigrationClass1());
		migrationProvider.addMigratorResource("/com/mygrator/cassandra/migrations/migrationfile.cql");

		MyGrator<Session> myGrator = MyGrator.<Session>builder()
				.setResourceProvider(this)
				.addMigrationProvider(migrationProvider)
				.setUser("UserName")
				.setHistoryStoreName("migration").build();

		myGrator.initialize();

		MigrationResult result = myGrator.migrateAll();

		myGrator.close();

	}

	@Override
	public Session getResource() {
		return session;
	}


}
