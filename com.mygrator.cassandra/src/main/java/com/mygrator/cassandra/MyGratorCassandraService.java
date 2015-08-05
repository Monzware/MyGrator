package com.mygrator.cassandra;

import com.datastax.driver.core.Session;
import com.mygrator.MyGratorService;

public class MyGratorCassandraService implements MyGratorService {

	@Override
	public boolean provides(Class<?> providerClass) {
		return Session.class.equals(providerClass);
	}

	@Override
	public boolean supportsRollback() {
		return false;
	}
	
	
	
	

}
