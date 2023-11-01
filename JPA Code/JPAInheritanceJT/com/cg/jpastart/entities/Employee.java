package com.cg.jpastart.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "emp_store")
@Inheritance(strategy = InheritanceType.JOINED) // This annotation must be written only on parent class
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int employeeId;
	@Column(length=25)
	private String name;
	private double salary;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeId: " + employeeId + " Name: " + name + " Salary=" + salary;
	}

}
