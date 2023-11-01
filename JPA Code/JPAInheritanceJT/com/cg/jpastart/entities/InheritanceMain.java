package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InheritanceMain {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		// create one employee
		Employee employee = new Employee();
		employee.setEmployeeId(100);
		employee.setName("John");
		employee.setSalary(5000);
		em.persist(employee);

		// create one manager
		Manager manager = new Manager();
		manager.setEmployeeId(200);
		manager.setName("Trisha");
		manager.setSalary(8000);
		manager.setDepartmentName("Sales");
		em.persist(manager);
		
		// create Director
		Director dir=new Director();
		dir.setEmployeeId(300);
		dir.setName("Ravi Kumar");
		dir.setSalary(45000);
		dir.setDepartmentName("All Depts");
		dir.setClient("General Motors");
		em.persist(dir);

		em.getTransaction().commit();

		System.out.println("Added one employee and manager and director to database.");

		Employee e1 = em.find(Employee.class, 100);
		Manager m1 = em.find(Manager.class, 200);
		Director d1=em.find(Director.class, 300);

		System.out.println(e1);
		System.out.println(m1);
		System.out.println(d1);

		em.close();
		factory.close();
	}
}
