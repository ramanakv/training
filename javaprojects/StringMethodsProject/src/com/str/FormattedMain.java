package com.str;

public class FormattedMain {

	public static void main(String[] args) {
		String msg = "Your name is %s and Your age is %d\n".formatted("Nick", 18);
		System.out.println(msg); 
		
		System.out.printf(msg, "Nick",18);
	}

}
