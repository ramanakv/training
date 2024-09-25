package trg.jpa;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class QueryMain {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA1");

		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("from Employee e order by e.salary desc");
		
		List<Employee> list = q.getResultList();
		
		list.stream().forEach(System.out::println);

		em.close();
		emf.close();
	}
}
