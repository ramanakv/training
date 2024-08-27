package com.boot.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.boot.beans.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	static Map<Integer, Employee> data = new HashMap<>();

	static {
		data.put(100, new Employee(100, "Suresh", 8000));
		data.put(200, new Employee(200, "Manish", 23000));
	}

	@Override
	public Employee getEmployee(int eid) {

		return data.get(eid);
	}

	@Override
	public List<Employee> getAllEmployees() {
		Collection<Employee> col = data.values();
		List<Employee> list = new ArrayList<>();
		list.addAll(col);

		return list;
	}

	@Override
	public String saveEmployee(Employee e) {
		int id = e.getEmpId();
		if (data.containsKey(id)) {
			return "Employee data already exists";
		} else {
			data.put(id, e);
			return "Employee data successfully saved";
		}
	}

	@Override
	public String updateEmployee(Employee e) {
		int id = e.getEmpId();
		if (data.containsKey(id)) {
			data.put(id, e);
			return "Employee data successfully updated";
		} else {

			return "Update failed!!! Employee does not exist";
		}

	}

	@Override
	public String deleteEmployee(int id) {
		
		if (data.containsKey(id)) {
			data.remove(id);
			return "Employee date successfully deleted";
		} else {

			return "Delete failed!!! Employee does not exist";
		}

	}

}
