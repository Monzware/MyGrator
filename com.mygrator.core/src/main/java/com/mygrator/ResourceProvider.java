package com.mygrator;

public interface ResourceProvider<T> {
	
	T getResource();
	
	Class<T> getProviderClass();

}
