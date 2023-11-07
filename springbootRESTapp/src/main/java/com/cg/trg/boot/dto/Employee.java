package com.cg.trg.boot.dto;

import java.time.LocalDate;

public class Employee {
	
	private int empid;
	private String name;
	private LocalDate dob;
	private int salary;
	
	public Employee(int empid, String name, LocalDate dob, int salary) {
		super();
		this.empid = empid;
		this.name = name;
		this.dob = dob;
		this.salary = salary;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", dob=" + dob + ", salary=" + salary + "]";
	}
	
	

}
