package com.jpa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.entity.Employee;
import com.jpa.exceptions.DuplicateEmployeeException;
import com.jpa.exceptions.EmployeeNotFoundException;
import com.jpa.exceptions.EmptyDataException;
import com.jpa.repository.EmployeeRepository;

@Component
public class EmployeeJpaDaoImpl implements EmployeeDao {

	@Autowired
	EmployeeRepository repository;

	@Override
	public void save(Employee e) {
		if (repository.existsById(e.getEmpid()))
			throw new DuplicateEmployeeException("Employee with id " + e.getEmpid() + " already exists");
		repository.save(e);
	}

	@Override
	public boolean update(Employee e) {

		if (repository.existsById(e.getEmpid())) {
			repository.save(e);
			return true;
		} else
			throw new EmployeeNotFoundException("Update", "Employee with Id " + e.getEmpid() + " to update not found");

	}

	@Override
	public boolean delete(int id) {

		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		} else
			throw new EmployeeNotFoundException("Delete", "Employee with Id " + id + " to delete not found");
	}

	@Override
	public Employee getEmployee(int id) {
		Optional<Employee> opt = repository.findById(id);
		if (opt.isPresent())
			return opt.get();
		else
			throw new EmployeeNotFoundException("Request", "Employee with id " + id + " not found");

	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = (List<Employee>) repository.findAll();
		if (list.size() == 0)
			throw new EmptyDataException("No employees in database");
		return list;
	}

}
