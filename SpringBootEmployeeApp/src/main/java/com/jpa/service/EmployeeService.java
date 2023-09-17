package com.jpa.service;

import java.util.List;

import com.jpa.entity.Employee;

public interface EmployeeService {

	Employee get(int id);

	List<Employee> getAll();

	void add(Employee e);

	void update(Employee e);

	void delete(int id);

}
