package com.jpa.dao;

import java.util.List;

import com.jpa.entity.Employee;


public interface EmployeeDao {
	void save(Employee e);
	boolean update(Employee e);
	boolean delete(int id);
	Employee getEmployee(int id);
	List<Employee> getAllEmployees();

}
