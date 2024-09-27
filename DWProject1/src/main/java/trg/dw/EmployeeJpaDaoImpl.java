package trg.dw;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class EmployeeJpaDaoImpl implements EmployeeDao {

	EntityManagerFactory emf;
	EntityManager em;

	public EmployeeJpaDaoImpl() {
		super();
		emf = Persistence.createEntityManagerFactory("JPA1");
		em = emf.createEntityManager();
	}

	@Override
	public Employee getEmployee(int id) {

		Employee e = em.find(Employee.class, id);
		return e;
	}

	@Override
	public List<Employee> getAllEmployees() {

		Query q = em.createQuery("from Employee");
		List<Employee> list = q.getResultList();
		return list;
	}

	@Override
	public void saveEmployee(Employee e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}

	@Override
	public void deleteEmployee(int id) {

		Employee e = em.find(Employee.class, id);
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
	}

	@Override
	public void updateEmployee(Employee e) {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}

}
