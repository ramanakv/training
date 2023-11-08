package com.cg.trg.boot.service;

import java.util.Collection;

import com.cg.trg.boot.dto.Employee;

public interface EmployeeService {
	
	boolean addEmployee(Employee e);
	Employee getEmployee(int eid);
	boolean deleteEmployee(int eid);
	boolean grantIncrement(int eid, int percent);
	boolean updateEmployee(Employee e);
	Collection<Employee> getAllEmployees();

}
