package com.mygrator;

public interface MyGratorService {
	
	boolean provides(Class<?> providerClass);
	
	boolean supportsRollback();
	
	

}
