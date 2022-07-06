package inheritanceproject;

public class Employee extends Person {
	private int empId;
	private float salary;


	public Employee(int id, String nm, String gen, int age, float sal) {
		super(nm,gen,age);
		
		empId=id;
		salary=sal;
	}
	
	public int getEmpId() {
		return empId;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public void display() {
		System.out.println("Emp Id: " + empId);
		super.display();
		System.out.println("Salary: " + salary);
	}
}
