package inheritanceproject;

public class Student extends Person {
	private int studentId;
	private float marks;

	public Student(int id, String nm, String gen, int age, float mks) {
		super(nm, gen, age);

		studentId = id;
		marks = mks;
	}

	public int getStudentId() {
		return studentId;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

	public void display() {
		System.out.println("Student Id: " + studentId);
		super.display();
		System.out.println("Marks: " + marks);
	}
}