package trg.jpa.jpa1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import trg.jpa.Student;

/**
 * Hello world!
 *
 */
public class SaveMain {
	public static void main(String[] args) {
		// create EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA1");
		// create EntityManager
		EntityManager em = emf.createEntityManager();

		// use em to handle persistence

		Student s1 = new Student(11, "Alok Kumar", 34.5);
		Student s2 = new Student(22, "Srinidhi", 78.6);
		Student s3 = new Student(33, "Naresh", 88.6);
		Student s4 = new Student(44, "Pankaj", 92.5);
		Student s5 = new Student(55, "Latha", 69.4);

		em.getTransaction().begin();
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(s4);
		em.persist(s5);
		em.getTransaction().commit();

		em.close();
		emf.close();
		
		System.out.println("Student objects saved to the table");

	}
}
