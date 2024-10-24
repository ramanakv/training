package prototypepatternproject;

public class PrototypeMain {

	public static void main(String[] args) {
		Employee e1 = new Employee(100, "Ramana", 5600,"java","javascript","HTML");
		Employee e2 = e1.createCopy();

		System.out.println("e1 is " + e1);
		System.out.println("e2 is " + e2);

		e1.setSalary(99000);
		e1.setName("Sudhir");
		
		System.out.println("======= After changing salary of e1 ===============");
		
		System.out.println("e1 is " + e1);
		System.out.println("e2 is " + e2);
		
		e2.addSkill("Spring");
		e2.addSkill("Hibernate");
		
System.out.println("======= After adding new skills to e2 ==============");
		
		System.out.println("e1 is " + e1);
		System.out.println("e2 is " + e2);
		

	}

}
