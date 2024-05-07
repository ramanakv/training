
module service.db {
  //exports com.db;
  requires mod.service;
  requires java.sql;
  provides com.service.EmployeeService with com.db.EmployeeDbService;
}