package com.trg.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
	int empId;
	String name;
	
	@Autowired
	Department dept;
	
	float salary;
	
	
	
	public Employee() {
		super();
	}
	public Employee(int empId, String name, Department dept, float salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.dept = dept;
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
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}
	
	public void method1() {
		System.out.println("Emp Bean with  id "+empId +" created");
	}

	public void method2() {
		System.out.println("Emp Bean with  id "+empId +" destroyed");
	}
}
