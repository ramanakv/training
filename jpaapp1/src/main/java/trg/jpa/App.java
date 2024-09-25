package trg.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA1");

		EntityManager em = emf.createEntityManager();

		Employee e1 = new Employee(100, "Ramana", 45000);
		Employee e2 = new Employee(200, "Suresh", 25000);
		Employee e3 = new Employee(300, "Manish", 34000);

		em.getTransaction().begin();
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.getTransaction().commit();
		em.close();
		emf.close();

		System.out.println("Three objects saved");
	}
}
