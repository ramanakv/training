package trg.sf;

public class Teacher {

	private int teacherId;
	private String name;

	public Teacher() {
		super();
	}

	public Teacher(int teacherId, String name) {
		super();
		this.teacherId = teacherId;
		this.name = name;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", name=" + name + "]";
	}

}
