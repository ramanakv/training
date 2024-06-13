package com.adapter;

public class AdapterMain {

	public static void main(String[] args) {

		TempAdapter reporter = AdapterFactory.getAdapter("object");

		reporter.setTempInC(34.5);

		System.out.println("Temp in Celcius: " + reporter.getTempInC());

		System.out.println("Temp in Foreignheat: " + reporter.getTempInF());

		reporter.setTempInF(94.1);
		
		System.out.println("================================");
		
		System.out.println("Temp in Celcius: " + reporter.getTempInC());

		System.out.println("Temp in Foreignheat: " + reporter.getTempInF());

	}

}
