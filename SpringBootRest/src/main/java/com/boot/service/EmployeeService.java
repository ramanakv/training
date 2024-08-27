package com.boot.service;

import java.util.List;

import com.boot.beans.Employee;

public interface EmployeeService {
	Employee getEmployee(int eid);

	List<Employee> getAllEmployees();

	String saveEmployee(Employee e);
	
	String updateEmployee(Employee e);
	
	String deleteEmployee(int id);

}
