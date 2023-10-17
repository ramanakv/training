package com.cg.trg.lapp.dao;

import java.util.Collection;

import com.cg.trg.lapp.dto.Employee;
import com.cg.trg.lapp.exceptions.DuplicateEmployeeException;

public interface EmployeeDao {
	
	void save(Employee e)  throws DuplicateEmployeeException;
	boolean update(Employee e);
	boolean delete(int empId);
	Employee getEmployee(int empId);
	Collection<Employee> getAllEmployees();

}
