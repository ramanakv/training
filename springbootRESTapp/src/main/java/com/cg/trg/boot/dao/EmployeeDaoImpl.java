package com.cg.trg.boot.dao;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.trg.boot.dto.Employee;
import com.cg.trg.boot.exceptions.DuplicateEmployeeException;



public class EmployeeDaoImpl implements EmployeeDao {

	Map<Integer, Employee> data = new HashMap<Integer, Employee>();

	public EmployeeDaoImpl() {
		data.put(100, new Employee(100, "Kishore", LocalDate.of(1989, 12, 21), 24000));
		data.put(200, new Employee(200, "Kirthi", LocalDate.of(1992, 5, 15), 44000));
		data.put(300, new Employee(300, "Ashok", LocalDate.of(1995, 2, 2), 25000));
		data.put(400, new Employee(400, "Rajesh", LocalDate.of(1996, 1, 15), 36000));
	}

	@Override
	public void save(Employee e) throws DuplicateEmployeeException {
		if (data.containsKey(e.getEmpid()))
			throw new DuplicateEmployeeException("Employee with id " + e.getEmpid() + " already exists");
		data.put(e.getEmpid(), e);

	}

	@Override
	public boolean update(Employee e) {

		if (data.containsKey(e.getEmpid())) {
			data.put(e.getEmpid(), e);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean delete(int empId) {
		if (data.containsKey(empId)) {
			data.remove(empId);
			return true;
		}
		
		return false;
	}

	@Override
	public Employee getEmployee(int empId) {
		Employee x = data.get(empId);
		return x;
	}

	@Override
	public Collection<Employee> getAllEmployees() {
		Collection<Employee> col = data.values();
		return col;
	}

}
