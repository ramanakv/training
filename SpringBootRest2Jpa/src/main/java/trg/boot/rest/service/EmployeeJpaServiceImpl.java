package trg.boot.rest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trg.boot.rest.beans.Employee;
import trg.boot.rest.repo.EmployeeRepository;

@Service("jpaservice")
public class EmployeeJpaServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repo;

	@Override
	public Employee getEmployee(int eid) {

		Optional<Employee> opt = repo.findById(eid);
		if (opt.isPresent()) {
			Employee e = opt.get();
			return e;
		}

		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {

		return repo.findAll();

	}

	@Override
	public String saveEmployee(Employee e) {

		if (repo.existsById(e.getEmpId())) {
			return "Employee data already exists";
		} else {
			repo.save(e);
			return "Employee data successfully saved";
		}
	}

	@Override
	public String updateEmployee(Employee e) {
		if (repo.existsById(e.getEmpId())) {
			repo.save(e);
			return "Employee data successfully updated";

		} else {

			return "Update failed!!! Employee does not exist";
		}

	}

	@Override
	public String deleteEmployee(int id) {

		if (repo.existsById(id)) {
			repo.deleteById(id);
			return "Employee data successfully deleted";

		} else {

			return "Delete failed!!! Employee does not exist";
		}

	}

}
