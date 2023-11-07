package com.cg.trg.boot.dao;

import java.util.Collection;

import com.cg.trg.boot.dto.Employee;
import com.cg.trg.boot.exceptions.DuplicateEmployeeException;

public interface EmployeeDao {
	
	void save(Employee e)  throws DuplicateEmployeeException;
	boolean update(Employee e);
	boolean delete(int empId);
	Employee getEmployee(int empId);
	Collection<Employee> getAllEmployees();

}
