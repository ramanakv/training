package trg.jpa;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App1 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA1");

		EntityManager em = emf.createEntityManager();

		Employee e1 = new Employee(100, "Sunil", 67890, LocalDate.of(1988, 1, 13));
		Employee e2 = new Employee(200, "Jaishankar", 67000, LocalDate.of(1988, 11, 23));
		Employee e3 = new Employee(300, "Kamal", 24000, LocalDate.of(1992, 1, 13));
		Employee e4 = new Employee(400, "Alok", 55000, LocalDate.of(1990, 1, 13));

		em.getTransaction().begin();
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);
		em.getTransaction().commit();

		emf.close();

	}

}
