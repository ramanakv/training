package com.choresp;

import java.util.Scanner;

public class CofRespMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount");
		int amount = sc.nextInt();

		ATMMachine atm = new ATMMachine();
		atm.dispense(new Currency(amount));
	}

}
