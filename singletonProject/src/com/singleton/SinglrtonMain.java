package com.singleton;

public class SinglrtonMain {

	public static void main(String[] args) {
		Logger l1 = Logger.getLogger();

		l1.writeMessage("Application started");
		method1();
		l1.writeMessage("Calling AddNumbers method");
		int result = addNumbers(34, 44);

		l1.writeMessage("Result " + result+ " received from addNumbers method");
		
		l1.writeMessage("Application completed");
	}

	public static void method1() {

		Logger log = Logger.getLogger();
		log.writeMessage("method1 is called");

		// some code

		log.writeMessage("method1 completed");

	}

	public static int addNumbers(int x, int y) {

		Logger l = Logger.getLogger();
		l.writeMessage("Call received with values " + x + "  " + y);
		return x + y;

	}

}
