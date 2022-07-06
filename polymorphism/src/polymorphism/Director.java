package polymorphism;

public class Director extends Employee {

	private String client;

	public Director(int empId, String name, float salary, String client) {
		super(empId, name, salary);
		this.client = client;
	}

	@Override
	public int getBonusPercent() {

		return 20;
	}

	public void showDetails() {
		super.showDetails();
		System.out.println("Client: " + client);
	}

}
