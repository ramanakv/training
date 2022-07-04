
public class AccountMain {

	public static void main(String[] args) {
	
		Account a1 =new Account(111, "Ashish", 2000);
		a1.showDetails();
		
		System.out.println(a1.getName());
		
		System.out.println("=====deposit========");

		a1.deposit(-100);
		a1.showDetails();
		
		System.out.println("===========WITHDRAW=========");
		a1.withdraw(5000);
		
		a1.showDetails();
	}

}
