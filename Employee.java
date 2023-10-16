package com.cg.trg.data;

import java.time.LocalDate;
import java.util.Objects;

public class Employee  implements Comparable<Employee>{

	private int empId;
	private String name;
	private char gender;
	private LocalDate dob;
	public Employee(int empId, String name, char gender, LocalDate dob) {
		super();
		this.empId = empId;
		this.name = name;
		this.gender = gender;
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", gender=" + gender + ", dob=" + dob + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(empId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empId == other.empId;
	}
	@Override
	public int compareTo(Employee o) {
		
		return this.empId - o.empId;
	}
	
}
