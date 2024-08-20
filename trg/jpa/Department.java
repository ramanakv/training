package trg.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEPT_MASTER")
public class Department {

	@Id
	private int id;
	@Column(length=20)
	private String name;

	@OneToMany(mappedBy="department",cascade=CascadeType.ALL)
	private Set<Employee> employees = new HashSet<>();		//Initialization required to avoid NullPointerException

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	//the method below will add employee to department 
	//also serves the purpose to avoid cyclic references. 
	public void addEmployee(Employee employee) {
		employee.setDepartment(this);			//this will avoid nested cascade
		this.getEmployees().add(employee);
	}

	
}
