package com.jpa.service;

import java.util.List;

import com.jpa.entity.Employee;


public interface EmployeeService {

	Employee get(int id);

	List<Employee> getAll();

	boolean add(Employee e);

	boolean update(Employee e);

	boolean delete(int id);

}
