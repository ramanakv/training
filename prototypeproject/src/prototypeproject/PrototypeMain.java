package prototypeproject;

public class PrototypeMain {

	public static void main(String[] args) throws CloneNotSupportedException {
	
		Employee e1 = new Employee(100,"Ramana",23000);
		Employee e2 =  (Employee) e1.clone();  //shallow copy
		
		System.out.println(e1);
		System.out.println(e2);

		e1.addSkill("Spring Boot");
		
		System.out.println(e1);
		System.out.println(e2);

	}

}

