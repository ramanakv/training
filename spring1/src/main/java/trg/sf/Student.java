package trg.sf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {

	private int studentId;
	private String name;
	
	@Autowired
	@Qualifier(value = "teacher1")
	private Teacher teacher;

	public Student() {
		super();
	}

	public Student(int studentId, String name) {
		super();
		this.studentId = studentId;
		this.name = name;

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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", teacher=" + teacher + "]";
	}

}
