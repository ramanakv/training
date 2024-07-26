package trg.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class AppQuery {

	public static void main(String[] args) {
		// create entitymanagerfactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA1");

		// create EntityManager

		EntityManager em = emf.createEntityManager();

		Query  q = em.createQuery(" select e from Employee e ");
		
		List<Employee> list = q.getResultList();
		
		for(Employee e:list) {
			System.out.println(e);
		}
		
		emf.close();

	}

}
