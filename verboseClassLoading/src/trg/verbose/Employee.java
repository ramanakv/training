package trg.verbose;

public class Employee {

	int empId;
	String name;
	public Employee(int empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}
	@Override
	public String toString() {
		return "EmpId=" + empId + ", name=" + name ;
	}
	
	
}
