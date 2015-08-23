package com.mygrator.cassandra.persistence;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;

@Accessor
public interface MigrationHistoryAccessor {
    
    @Query("SELECT * FROM " + MigrationHistoryPO.TABLE_NAME)
    public Result<MigrationHistoryPO> getAll();

}