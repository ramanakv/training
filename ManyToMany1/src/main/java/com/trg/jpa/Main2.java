package com.trg.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main2 {

	
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA1");
		EntityManager em = factory.createEntityManager();
		
		
		System.out.println("================ Details of Order 1000===========");
		Order ord=em.find(Order.class,  1000);
		
		ord.show();
		
		System.out.println("==============Details of Product 1==========================");
		
		Product p = em.find(Product.class, 1);
		p.show();
		
		em.close();
	}
}
