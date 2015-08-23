package com.mygrator.migrator;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.mygrator.exception.MigrationException;


public abstract class AbstractClasspathFileMigrator<T> implements ClassMigrater<T> {

	private String script;

	public AbstractClasspathFileMigrator(String resource) {

		InputStream resourceAsStream = getClass().getResourceAsStream(resource);
		try {
			script = IOUtils.toString(resourceAsStream, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	abstract public void doMigration(T resource) throws MigrationException;

	protected String getScript() {
		return script;
	}

}
