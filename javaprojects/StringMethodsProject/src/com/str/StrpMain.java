package com.str;

public class StrpMain {

	public static void main(String[] args) {
		String str = "     Hello World     ";
		System.out.println("[" + str + "]");
		System.out.println("[" + str.strip() + "]");
		System.out.println("[" + str.stripLeading() + "]");
		System.out.println("[" + str.stripTrailing() + "]");
	}

}
