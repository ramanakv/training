package com.cg.jpastart.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mgr_store")
public class Manager extends Employee {

	private static final long serialVersionUID = 1L;
	
	@Column(length = 25)
	private String departmentName;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return super.toString() + " DepartmentName: " + departmentName;
	}

}
