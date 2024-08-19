package trg.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "stdid")
	private int studentId;
	@Column(length = 20)
	private String name;
	@Column(length = 4,precision = 2)
	private double marks;

	public Student() {
		super();
	}

	public Student(int studentId, String name, double marks) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.marks = marks;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", marks=" + marks + "]";
	}

}
