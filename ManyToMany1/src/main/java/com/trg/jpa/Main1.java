package com.trg.jpa;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main1 {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA1");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		// first define few products before we place order

		Product p1 = new Product();
		p1.setId(1);
		p1.setName("LED TV");
		p1.setPrice(45000);

		Product p2 = new Product();
		p2.setId(2);
		p2.setName("Face Wash");
		p2.setPrice(80);

		Product p3 = new Product();
		p3.setId(3);
		p3.setName("Pampers");
		p3.setPrice(15);

		Product p4 = new Product();
		p4.setId(4);
		p4.setName("CFL Bulb");
		p4.setPrice(250);

		// now define first order and add few products in it
		Order order1 = new Order();
		order1.setId(1000);
		order1.setPurchaseDate(new Date(121,5,21));

		order1.addProduct(p3);
		order1.addProduct(p1);
		order1.addProduct(p2);

		// now define second order and add few products in it
		Order oder2 = new Order();
		oder2.setId(1001);
		oder2.setPurchaseDate(new Date(121,10,12));

		oder2.addProduct(p3);		
		oder2.addProduct(p1);
		oder2.addProduct(p4);

		// save orders using entity manager

		em.persist(order1);
		em.persist(oder2);
		
		System.out.println("Added orders along with order details to database.");

		em.getTransaction().commit();
		em.close();
		factory.close();
		
		
	}
}
