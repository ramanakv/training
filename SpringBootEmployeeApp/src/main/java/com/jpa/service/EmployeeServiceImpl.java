package com.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jpa.dao.EmployeeDao;
import com.jpa.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao dao;

	@Override
	public Employee get(int id) {
		return dao.getEmployee(id);
	}

	@Override
	public List<Employee> getAll() {
		return dao.getAllEmployees();
	}

	@Override
	public void add(Employee e) {
		dao.save(e);
	}

	@Override
	public void update(Employee e) {
		dao.update(e);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

}
