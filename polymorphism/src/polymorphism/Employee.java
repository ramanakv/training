package polymorphism;

 abstract public class Employee {
	private int empId;
	private String name;
	private float salary;

	public Employee(int empId, String name, float salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

	
	public float getSalary() {
		return salary;
	}
	
	abstract public int getBonusPercent();
	
	
	public void showDetails() {
		System.out.println("Emp Id: " + empId);
		System.out.println("Name: " + name);
		System.out.println("Salary: " + salary);
	}

}

 