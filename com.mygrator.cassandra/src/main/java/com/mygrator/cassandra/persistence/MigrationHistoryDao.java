package com.mygrator.cassandra.persistence;

import java.util.Collection;

import com.datastax.driver.core.KeyspaceMetadata;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.TableMetadata;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;
import com.mygrator.exception.MigrationException;

public class MigrationHistoryDao {
	
	private Session session;

	public MigrationHistoryDao(Session session) {
		this.session = session;		
	}
	
	public Collection<MigrationHistoryPO> getMigrationHistory() {
		
		validateTableExistance();
		
		MappingManager manager = new MappingManager(session);
		MigrationHistoryAccessor accessor = manager.createAccessor(MigrationHistoryAccessor.class);
		Result<MigrationHistoryPO> all = accessor.getAll();
		return all.all();
	}

	private void validateTableExistance() {
		
		KeyspaceMetadata ks = session.getCluster().getMetadata().getKeyspace(session.getLoggedKeyspace());
		TableMetadata table = ks.getTable(MigrationHistoryPO.TABLE_NAME);
		
		if (table == null) {
			
			CassandraClassPathFileMigrator migrator = new CassandraClassPathFileMigrator("/CreateMigrationHistory.cql");
			try {
				migrator.doMigration(session);
			} catch (MigrationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
