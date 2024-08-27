package trg.boot.rest.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  //mandatory
@Table(name = "emptbl")  // optional. if not given class name is mapped to table name
public class Employee {
	
	@Id   // manadatory
	@Column(name="empid")
	private int empId;
	@Column(name = "empname") // optional. if not given field name mapped to column name
	private String name;
	private float salary;

	public Employee() {

	}

	public Employee(int empId, String name, float salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}
