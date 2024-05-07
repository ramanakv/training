package com.str;

public class IndentMain {

	public static void main(String[] args) {
		String poem = "Two loves I have of comfort and despair,\n" 
					   + "Which like two spirits do suggest me still:\n"
					   + "The better angel is a man right fair,\n" 
					   + "The worser spirit a woman color’d ill.\n";

		System.out.println(poem);
		System.out.println(poem.indent(4));
		System.out.println(poem.indent(10));

	}

}
