package com.logger;

public class SingletonMain {

	public static void main(String[] args) {
		Logger logger = Logger.getInstance();

		logger.logMessage("This is first message from main method");
		someMethod();
		Dummy d = new Dummy();
		d.show();
		
		Logger l1 = Logger.getInstance();
		Logger l2 = Logger.getInstance();
		Logger l3 = Logger.getInstance();
		
		System.out.println(l1 == l2);
		System.out.println(l2 == l3);
				

	}
	
	static void someMethod() {
		
		Logger log = Logger.getInstance();
		log.logMessage("someMethod() started");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.logMessage("someMethod() ended");
		
		
	}

}
