package inheritanceproject;

public class Main {

	public static void main(String[] args) {
		Employee e1= new Employee(111,"Kishore","Male",25,6000);
		e1.display();
		System.out.println("==================================");
		Employee e2= new Employee(222,"Manisha","Female",24,6500);
		e2.display();
		
		System.out.println("Student data");
		System.out.println("============");
		Student s1= new Student(10,"Kishore","Male",15,78.5f);
		s1.display();
		System.out.println("==================================");
		Student s2= new Student(20,"Manisha","Female",13,89.7f);
		s2.display();
		
		
	}

}
