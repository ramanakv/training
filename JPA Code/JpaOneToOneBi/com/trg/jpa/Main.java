package com.trg.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA1");
		EntityManager em = factory.createEntityManager();
	/*	
		em.getTransaction().begin();
		
		Student student1 = new Student();
		student1.setStudentId(200);
		student1.setName("Hiren Jha");
		Address address1 = new Address();
		address1.setAddressId(211);
		address1.setStreet("MG Road");
		address1.setCity("Pune");
		address1.setState("Maharashtra");
		address1.setPinCode("511017");
		
		//Add address into student
		student1.setAddr(address1);
		
		//persist only student, no need to persist Address explicitly
		em.persist(student1);
		System.out.println(student1);
		System.out.println("Added Student with address to database.");
		
		Student student2 = new Student();
		student2.setStudentId(300);
		student2.setName("Suresh Kumar");
		
		Address address2 = new Address();
		student2.setAddr(address2);
		address2.setAddressId(311);
		address2.setStreet("Cocktail street");
		address2.setCity("Kakinada");
		address2.setState("A P");
		address2.setPinCode("411009");
		//Add student to address
		address2.setStudent(student2);
		
		em.persist(address2);
		System.out.println(address2);
		
		System.out.println("Added Address with Student to database.");
		
		em.getTransaction().commit();
		
	*/	
		Student std=em.find(Student.class,200);
		System.out.println(std);
		em.close();
		factory.close();
	}
}
