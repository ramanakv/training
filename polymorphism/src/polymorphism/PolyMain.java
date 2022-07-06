package polymorphism;

public class PolyMain {

	public static void main(String[] args) {

		Developer dev = new Developer(101, "Sudhir", 20000, "java");
		Manager man = new Manager(201, "Alok Singh", 35000, "Banking", "Bangaluru");
		Director dir = new Director(301, "Gyanendra", 60000, "Microsoft");

		handle(dev);
		System.out.println("======================");
		handle(man);
		System.out.println("======================");
		handle(dir);
		System.out.println("======================");

	}

	static void handle(Employee e) {
		e.showDetails();
		
		float bonus = e.getSalary()*e.getBonusPercent()/100;
		System.out.println("Bonus: "+bonus);
		
	}

}
