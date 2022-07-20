package com.trg;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class EmpService {

	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();

	public EmpService() {

		empData.put(100, new Employee(100, "Suresh", 35000, LocalDate.of(1997, 8, 15)));
		empData.put(200, new Employee(200, "Naresh", 25000, LocalDate.of(1998, 10, 25)));
		empData.put(300, new Employee(300, "Manish", 23000, LocalDate.of(1999, 6, 17)));
		empData.put(400, new Employee(400, "Ritesh", 37000, LocalDate.of(1999, 4, 5)));
		empData.put(500, new Employee(500, "Mahesh", 21000, LocalDate.of(1992, 5, 1)));
		empData.put(600, new Employee(600, "Satish", 37000, LocalDate.of(1994, 10, 22)));
		empData.put(700, new Employee(700, "Rajech", 16000, LocalDate.of(1988, 12, 18)));
	}

	public Employee getEmployee(int empId) {

		Employee e = empData.get(empId);
		return e;
	}

	public boolean saveEmployee(Employee e) {

		if (empData.containsKey(e.getEmpId())) {
			return false;
		}
		empData.put(e.getEmpId(), e);
		return true;
	}

	public boolean deleteEmployee(int empId) {

		if (empData.containsKey(empId)) {
			empData.remove(empId);
			return true;
		}

		return false;
	}
}
