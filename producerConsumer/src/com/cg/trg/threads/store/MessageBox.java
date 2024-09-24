package com.cg.trg.threads.store;

public class MessageBox {

	private String message = "";

	synchronized public void storeMessage(String msg) {
	
		
		this.message = msg;

	}

	synchronized public String getMessage() {


		String temp = message;
		//message = "";

		return temp;
	}

}
