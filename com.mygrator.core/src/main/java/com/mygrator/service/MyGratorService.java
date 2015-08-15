package com.mygrator.service;

import com.mygrator.provider.ResourceProvider;

public interface MyGratorService<T> {

	boolean accept(ResourceProvider<?> resourceProvider);


}
