package trg.chain;

import java.util.Scanner;

public class CORMain {
	public static void main(String[] args) {
		
		CurrencyDispenser root = new DispenserOf500Rupees(new DispenserOf200Rupees(new DispenserOf100Rupees(null)));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter amount in multiples of 100");
		int amount = sc.nextInt();
		
		if(amount % 100 !=0)
			throw new RuntimeException("Amount should be multiples of 100");
		
		root.dispense(amount);
	}

}
