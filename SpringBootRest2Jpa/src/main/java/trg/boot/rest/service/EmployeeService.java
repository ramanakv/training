package trg.boot.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import trg.boot.rest.beans.Employee;

@Service
public interface EmployeeService {
	Employee getEmployee(int eid);

	List<Employee> getAllEmployees();

	String saveEmployee(Employee e);
	
	String updateEmployee(Employee e);
	
	String deleteEmployee(int id);

}
