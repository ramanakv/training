package prototypeproject;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Cloneable {

	private int empId;
	private String name;
	private int salary;

	private List<String> skillList;

	public Employee(int empId, String name, int salary) {
		super();

		skillList = new ArrayList<String>();
		skillList.add("Java");
		skillList.add("jpa");

		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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

	public List<String> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<String> skillList) {
		this.skillList = skillList;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Employee newEmp = (Employee) super.clone();

		List<String> list = new ArrayList<String>();

		list.addAll(skillList);
		newEmp.setSkillList(list);
		
		return newEmp;

	}

	public void addSkill(String skill) {
		skillList.add(skill);
	}

	@Override
	public String toString() {
		return "EmpId=" + empId + ", name=" + name + ", salary=" + salary + ", skills: " + skillList;
	}

}
