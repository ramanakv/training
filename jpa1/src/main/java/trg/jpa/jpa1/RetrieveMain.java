package trg.jpa.jpa1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import trg.jpa.Student;

public class RetrieveMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA1");
		// create EntityManager
		EntityManager em = emf.createEntityManager();

		int sid = 33;
		Student s = em.find(Student.class, sid);

		if (s == null)
			System.out.println("Student with id " + sid + " does not exist");
		else
			System.out.println(s);
		
		em.close();
		emf.close();

	}

}
