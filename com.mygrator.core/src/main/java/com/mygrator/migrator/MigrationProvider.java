package com.mygrator.migrator;

import java.util.Collection;

public interface MigrationProvider<T> {

	Collection<ClassMigrater<T>> getMigrations();


}
