package com.trg.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "emp_store")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // This annotation must be written only on parent class
@DiscriminatorColumn(name = "emp_type", discriminatorType = DiscriminatorType.STRING,length = 3) // additional column to differ
																						// parent and child
@DiscriminatorValue("EMP") // parent rows will have this value in Discriminator Column
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int employeeId;
	@Column(length = 10)
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
