package project2;

public class EmployeeMain {

	public static void main(String[] args) {

		Employee e1 = new Employee(100,"Suresh",6000);

		Employee e2 = new Employee(200,"Akash");
		
		Employee e3 = new Employee(300,"Madhulika",9999);
		
		e1.show();
		System.out.println("====================");
		e2.show();
		System.out.println("====================");
		e3.show();



		
	}

}
