package prototypepatternproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employee implements Cloneable {

	private int empId;
	private String name;
	private int salary;
	
	private List<String> skills;

	public Employee(int empId, String name, int salary, String... skills) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		
		this.skills=new ArrayList<String>(Arrays.asList(skills));
	}

	public int getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void addSkill(String skill) {
		skills.add(skill);
	}
	
	
	public Employee createCopy() {
		Employee e;
		try {
			e = (Employee) clone();  //shallow copy
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
			return null;
		}

		e.skills = new ArrayList<String>();
		
		e.skills.addAll(this.skills);
		return e;
	}

	@Override
	public String toString() {
		return "EmpId=" + empId + ", name=" + name + ", salary=" + salary + ", skills=" + skills ;
	}
	
}
