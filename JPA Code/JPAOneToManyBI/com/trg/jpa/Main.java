package com.trg.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Run onetomanybi.sql DDL before executing this program

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA1");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		// create a new department
		Department department = new Department();
		department.setId(10);
		department.setName("Sales");

		// create two instances of employees
		Employee e1 = new Employee();
		e1.setId(1001);
		e1.setName("Priya Sharma");
		e1.setSalary(4500);

		Employee e2 = new Employee();
		e2.setId(1002);
		e2.setName("Dinesh Kumar");
		e2.setSalary(5500);

		// add both employees to department
		department.addEmployee(e1);
		department.addEmployee(e2);

		// save department and its employees using entity manager
		em.persist(department);

		System.out.println("Added department along with two employees to database.");

		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
