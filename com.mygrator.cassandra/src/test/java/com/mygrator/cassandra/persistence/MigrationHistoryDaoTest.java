package com.mygrator.cassandra.persistence;

import java.util.Collection;

import org.cassandraunit.DataLoader;
import org.cassandraunit.dataset.xml.ClassPathXmlDataSet;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;


public class MigrationHistoryDaoTest {
	
	@Before
	public void before() throws Exception {

		EmbeddedCassandraServerHelper.startEmbeddedCassandra();

		DataLoader dataLoader = new DataLoader("TestCluster", "localhost:9171");
		dataLoader.load(new ClassPathXmlDataSet("EmptyDataSet.xml"));
	}
	
	@Test
	public void testGetMigrationHistory() {
		
		Cluster cluster = Cluster.builder().addContactPoints("localhost").withPort(9142).build();
		Session session = cluster.connect("emptykeyspace");
		
		MigrationHistoryDao dao = new MigrationHistoryDao(session);
		Collection<MigrationHistoryPO> migrationHistory = dao.getMigrationHistory();
		
		Assert.assertEquals(1, migrationHistory.size());
	}

}
