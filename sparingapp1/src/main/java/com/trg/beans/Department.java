package com.trg.beans;

public class Department {
	private int deptId;
	private String name;
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", name=" + name + "]";
	}

public void method1() {
	System.out.println("Dept Bean with id "+deptId+ " created");
}

public void method2() {
	System.out.println("Dept Bean with id "+deptId+ " destroyed");
}
}
