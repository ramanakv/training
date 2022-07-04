package project2;

public class Employee {

	private int empId;
	private String name;
	private float salary;
	static private String companyName="Wipro";
	

	public Employee(int eid, String name, float salary) {
		
		empId = eid;
		this.name = name;
		this.salary = salary;
	}

	public Employee(int empId, String name) {
		
		this.empId = empId;
		this.name = name;
		salary=25000;
	}

	public int getEmpId() {
	
		return empId;
	}


	public String getName() {
		return name;
	}

	public float getSalary() {
		return salary;
	}
	
	public static void setCompanyName(String cn) {
		companyName=cn;
	
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public void show() {
		System.out.println("Emp Id: " + empId);
		System.out.println("Name: " + name);
		System.out.println("Salary: " + salary);
	}


}
