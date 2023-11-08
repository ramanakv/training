package com.cg.trg.boot.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.trg.boot.dao.EmployeeDao;
import com.cg.trg.boot.dto.Employee;
import com.cg.trg.boot.exceptions.DuplicateEmployeeException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao dao;

	@Override
	public boolean addEmployee(Employee e) {
		dao.save(e);
		return true;

	}

	@Override
	public Employee getEmployee(int eid) {
		Employee x = dao.getEmployee(eid);
		return x;
	}

	@Override
	public boolean deleteEmployee(int eid) {
		return dao.delete(eid);
	}

	@Override
	public boolean grantIncrement(int eid, int percent) {
		Employee e = dao.getEmployee(eid);
		if (e == null)
			return false;
		int newSal = e.getSalary() + (int) ((float) e.getSalary() * percent / 100);
		e.setSalary(newSal);

		return dao.update(e);

	}

	@Override
	public Collection<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

	@Override
	public boolean updateEmployee(Employee e) {
		return dao.update(e);
	}

}
