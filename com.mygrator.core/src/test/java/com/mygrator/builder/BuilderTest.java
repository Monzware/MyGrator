package com.mygrator.builder;

import java.io.PrintStream;
import java.util.List;

import org.junit.Test;

import com.mygrator.MyGrator;
import com.mygrator.exception.MissingMigratorException;
import com.mygrator.model.Migration;
import com.mygrator.model.MigrationResult;
import com.mygrator.provider.ResourceProvider;

public class BuilderTest implements ResourceProvider<PrintStream> {

	@Test
	public void createBuilder() throws MissingMigratorException {

		MyGrator myGrator = MyGrator.builder().setResourceProvider(this).setUser("Peer Bech Hansen").setHistoryStoreName("databasemigration").build();

		myGrator.initialize();

		List<Migration> allMigrations = myGrator.getAllMigrations();
		List<Migration> pendingMigrations = myGrator.getPendingMigrations();

		Migration migration = myGrator.getMigration("id");

		MigrationResult result = myGrator.migrateTo(migration);
		result = myGrator.migrateAll();

		myGrator.close();

	}

	@Override
	public PrintStream getResource() {
		return System.out;
	}


}
