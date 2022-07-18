package data;

import java.time.LocalDate;

public class Employee {

	private int empId;
	private String name;
	private float salary;
	private LocalDate dob;

	public Employee(int empId, String name, float salary, LocalDate dob) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {     
		this.dob = dob;
	}

}
