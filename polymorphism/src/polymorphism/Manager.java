package polymorphism;

public class Manager extends Employee {
	private String project;
	private String location;

	public Manager(int empId, String name, float salary, String project, String location) {
		super(empId, name, salary);
		this.project = project;
	
		this.location = location;
	}

	@Override
	public int getBonusPercent() {
		return 15;
	}

	public void showDetails() {
		super.showDetails();
		System.out.println("Project: " + project);
		System.out.println("Location: " + location);
	}

}
