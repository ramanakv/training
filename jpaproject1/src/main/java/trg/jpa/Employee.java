package trg.jpa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMP")
public class Employee implements Comparable<Employee> {

	@Id
	private int empId;
	@Column(length = 15)
	private String name;
	private float salary;
	@Column(name="date_of_bith")
	private LocalDate dob;

	public Employee() {
		
	}
	
	public Employee(int empId, String name, float salary, LocalDate dob) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
	}

	public void display() {
		System.out.println("Emp Id: " + empId);
		System.out.println("Name: " + name);
		System.out.println("Salary: " + salary);

		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM yyyy");
		System.out.println("DOB: " + dob.format(df));

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
		if (salary < 10000)
			this.salary = 10000;
		else
			this.salary = salary;
	}

	
	
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public int hashCode() {
		return empId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Employee e = (Employee) obj;

		if (this.empId == e.empId)
			return true;
		else
			return false;
	}

	
	@Override
	public String toString() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM yyyy");

		return "EmpId:" + empId + ",Name:" + name + ",Salary:" + salary + ",DOB:" + dob.format(df);
	}

	@Override
	public int compareTo(Employee e) {
		if(this.empId < e.empId)
			return -1;
		if(this.empId > e.empId)
			return 1;
		return 0;
	}

}
