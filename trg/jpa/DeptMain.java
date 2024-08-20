package trg.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeptMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA1");
		// create EntityManager
		EntityManager em = emf.createEntityManager();
		// create a new department

		// create a new department
		Department department = new Department();
		department.setId(10);
		department.setName("Sales");

		// create two instances of employees
		Employee e1 = new Employee();
		e1.setId(100);
		e1.setName("Suresh Kumar");
		e1.setSalary(4500);

		Employee e2 = new Employee();
		e2.setId(200);
		e2.setName("Preethi Jain");
		e2.setSalary(5500);

		// add both employees to department
		department.addEmployee(e1);
		department.addEmployee(e2);

		// save department and its employees using entity manager
		em.getTransaction().begin();
		em.persist(department);
		em.getTransaction().commit();

		em.close();
		emf.close();
		System.out.println("Added department along with two employees to database.");

	}
}
