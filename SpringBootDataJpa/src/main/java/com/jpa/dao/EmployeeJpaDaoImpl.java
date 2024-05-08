package com.jpa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.entity.Employee;
import com.jpa.exceptions.DuplicateEmployeeException;
import com.jpa.repository.EmployeeRepository;

@Component
public class EmployeeJpaDaoImpl implements EmployeeDao {

	@Autowired
	EmployeeRepository repository;

	@Override
	public void save(Employee e) {
		if(repository.existsById(e.getEmpId()))
			throw new DuplicateEmployeeException("Employee with id "+e.getEmpId()+" already exists");
		repository.save(e);
	}

	@Override
	public boolean update(Employee e) {
		
		if (repository.existsById(e.getEmpId())) {
			repository.save(e);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {

		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Employee getEmployee(int id) {
		Optional<Employee> opt = repository.findById(id);
		if (opt.isPresent())
			return opt.get();

		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = (List<Employee>) repository.findAll();
		return list;
	}

}
