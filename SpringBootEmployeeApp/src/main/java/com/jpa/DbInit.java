package com.jpa;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.jpa.entity.Department;
import com.jpa.entity.Employee;
import com.jpa.repository.DepartmentRepository;
import com.jpa.repository.EmployeeRepository;

@Service
public class DbInit implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository deptRepository;

	Logger logger = LoggerFactory.getLogger(DbInit.class);

	
	@Override
	public void run(String... args) throws Exception {

		logger.info("H2 datbase created");
		Department d1 = new Department(10, "Sales");
		Department d2 = new Department(20, "Technical");

		deptRepository.save(d1);
		deptRepository.save(d2);

		employeeRepository.save(new Employee(100, "Dinesh", 22000, LocalDate.of(1998, 10, 21), d1));
		employeeRepository.save(new Employee(200, "Ganesh", 11000, LocalDate.of(1995, 5, 15), d2));
		employeeRepository.save(new Employee(300, "Mahesh", 20000, LocalDate.of(1999, 7, 25), d1));
		employeeRepository.save(new Employee(400, "Naresh", 16000, LocalDate.of(1988, 11, 20), d2));
		employeeRepository.save(new Employee(500, "Ritesh", 20000, LocalDate.of(1989, 8, 5), d2));
		employeeRepository.save(new Employee(600, "Suresh", 10000, LocalDate.of(1990, 5, 14), d1));
		
		logger.info("Data added to the tables");
	}

}
