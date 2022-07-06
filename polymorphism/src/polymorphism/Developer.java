package polymorphism;

public class Developer extends Employee {
	private String technology;

	public Developer(int empId, String name, float salary, String technology) {
		super(empId, name, salary);
		this.technology = technology;
	}

	@Override
	public int getBonusPercent() {

		return 10;
	}

	public void showDetails() {

		super.showDetails();
		System.out.println("Technology: " + technology);
	}

}
