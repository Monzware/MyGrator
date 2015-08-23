
CREATE TABLE migrationhistory (
  id timeuuid,
  name text,
  createdby_id timeuuid,
  starttime timestamp,
  endtime timestamp,
  type text,  
  PRIMARY KEY (id));