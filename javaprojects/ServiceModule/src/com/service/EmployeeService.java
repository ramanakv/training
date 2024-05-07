package com.service;

import com.entity.Employee;

public interface EmployeeService {
	String getType();
	Employee getEmployee(int eid);
	boolean saveEmployee(Employee e);

}
