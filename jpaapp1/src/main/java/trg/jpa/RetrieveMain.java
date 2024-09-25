package trg.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RetrieveMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA1");

		EntityManager em = emf.createEntityManager();
		
		Employee e = em.find(Employee.class, 500);
		
		System.out.println(e);
		em.close();
		emf.close();

	}

}
