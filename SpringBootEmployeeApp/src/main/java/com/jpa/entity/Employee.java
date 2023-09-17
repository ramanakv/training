package com.jpa.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "EMP")

public class Employee {
	@Id
	@Column(name = "empid")
	private int empid;

	@NotNull(message = "Name is Required")
	@Length(min = 5, max = 20, message = "Length of name should be between 5 and 20")
	private String name;

	@Range(min = 10000, max = 35000, message = "Salary should be in the range of 10000 and 35000")
	private float salary;

	private LocalDate dob;

	@ManyToOne
	@JoinColumn(name = "deptId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	
	private Department department;

	public Employee() {

	}

	public Employee(int empid, String name, float salary, LocalDate dob, Department department) {
		super();
		this.empid = empid;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
		this.department = department;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empid);
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
		return empid == other.empid;
	}

}
