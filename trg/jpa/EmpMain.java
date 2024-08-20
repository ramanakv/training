package trg.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpMain {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA1");
		// create EntityManager
		EntityManager em = emf.createEntityManager();
		// create a new department

		Department dept = new Department();
		dept.setId(11);
		dept.setName("Technical");

		Department dept1 = new Department();
		dept1.setId(22);
		dept1.setName("H R");

		// create two instances of Employee
		Employee e1 = new Employee();
		e1.setId(1001);
		e1.setName("Priya Sharma");
		e1.setSalary(4500);
		e1.setDepartment(dept);

		Employee e2 = new Employee();
		e2.setId(1002);
		e2.setName("Dinesh Kumar");
		e2.setSalary(5500);
		e2.setDepartment(dept1);
		
		em.getTransaction().begin();
		em.persist(e1);
		em.persist(e2);
		em.getTransaction().commit();
		System.out.println("Added two employees to database.");
		em.close();
		emf.close();

	}

}
