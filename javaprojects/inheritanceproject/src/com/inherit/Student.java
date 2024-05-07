package com.inherit;

public class Student extends Person {
	private int studentId;
	private double marks;

	public Student(String name, String address, int studentId, double marks) {
		super(name, address);
		this.studentId = studentId;
		this.marks = marks;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public void showResult() {
		if (marks < 40)
			System.out.println("Fail");
		else
			System.out.println("Pass");
	}

	@Override
	public void displayDetails() {
		System.out.println("Student Id: " + studentId);
		System.out.println("Name: " + getName());
		System.out.println("Address: " + getAddress());
		System.out.println("Marks: " + marks);
	}

}
