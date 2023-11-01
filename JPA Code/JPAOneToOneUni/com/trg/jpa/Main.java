package com.trg.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
	// Run onetooneuni.sql before executing this program	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA1");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Student student = new Student();
		student.setStudentId(100);
		student.setName("Deepak Patil");
		Address homeAddress = new Address();
		homeAddress.setAddressId(111);
		homeAddress.setStreet("MG Road");
		homeAddress.setCity("Pune");
		homeAddress.setState("Maharashtra");
		homeAddress.setPinCode("411017");
		
		//inject address into student
		student.setAddress(homeAddress);
		System.out.println(student);
		//persist only student, no need to persist Address explicitly
		em.persist(student);
		em.getTransaction().commit();
		
		System.out.println("Added one student with address to database.");
		
		Student s1 =em.find(Student.class, 100);
		System.out.println(s1);
		em.close();
		factory.close();
	}
}
