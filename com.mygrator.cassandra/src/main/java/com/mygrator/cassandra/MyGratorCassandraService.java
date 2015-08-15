package com.mygrator.cassandra;

import com.datastax.driver.core.Session;
import com.mygrator.provider.ResourceProvider;
import com.mygrator.service.MyGratorService;

public class MyGratorCassandraService implements MyGratorService<Session> {

	@Override
	public boolean accept(ResourceProvider<?> resourceProvider) {
		return resourceProvider.getResource().getClass().isAssignableFrom(Session.class);
	}
}
