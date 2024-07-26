package trg.jpa;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	public static void main(String[] args) {

		// create entitymanagerfactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA1");

		// create EntityManager

		EntityManager em = emf.createEntityManager();

		Employee e = em.find(Employee.class, 200);

		System.out.println(e);

		// Employee e1 = new Employee(111, "Suresh", 33333, LocalDate.of(199, 12, 21));

		e.setSalary(11111);
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();

		emf.close();

		System.out.println("Application Successfully completed");

	}
}
