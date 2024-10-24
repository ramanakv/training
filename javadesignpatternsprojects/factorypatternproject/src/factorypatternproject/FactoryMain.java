package factorypatternproject;

import java.util.MissingResourceException;
import java.util.Scanner;

public class FactoryMain {

	public static void main(String[] args) {

		Country country = null;
		try {
			country = CountryFactory.getCountry("abc");
		} catch (MissingResourceException ex) {

			System.out.println("Invalid country code");
			System.exit(0);
		}

		System.out.println(country.getCountryCode());

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter amount in rupees");
		double rupees = sc.nextDouble();
		double rate = country.getConversionRate();

		double amount = rupees / rate;
		System.out.println(rupees + " rupees is equal to " + amount + " " + country.getCurrency());

	}

}
