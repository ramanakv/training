package trg.boot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import trg.boot.rest.beans.Employee;
import trg.boot.rest.repo.EmployeeRepository;

@Component
public class DbInit implements CommandLineRunner {

	@Autowired
	EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {
		repo.save(new Employee(100, "Ramana", 34000));
		repo.save(new Employee(200, "Kiran", 56000));
		repo.save(new Employee(300, "Mithila", 62000));
		repo.save(new Employee(400, "Arun Kumar", 39000));

		System.out.println("4 rows inserted into the table");
	}

}
