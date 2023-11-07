package com.cg.trg.boot.service;

import java.util.Collection;

import com.cg.trg.boot.dao.EmployeeDao;
import com.cg.trg.boot.dto.Employee;
import com.cg.trg.boot.exceptions.DuplicateEmployeeException;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao dao ;
	
	@Override
	public boolean addEmployee(Employee e) {
		try {
			dao.save(e);
			return true;
		} catch (DuplicateEmployeeException e1) {
			return false;
		}
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
		if(e == null)
			return false;
		int newSal = e.getSalary() +(int)( (float)e.getSalary()*percent/100);
		e.setSalary(newSal);
		
		return dao.update(e);

	}

	@Override
	public Collection<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

	@Override
	public Employee getYoungestEmployee() {
		
		Collection<Employee> allEmployees = dao.getAllEmployees();
		Employee youngest = null;
		for(Employee e: allEmployees ) {
			
			if (youngest == null)
					youngest = e;
			if(e.getDob().compareTo(youngest.getDob() ) > 0)
				youngest = e;
		}
	
		return youngest;
	}

}
