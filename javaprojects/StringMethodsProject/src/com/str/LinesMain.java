package com.str;

import java.util.stream.Stream;

public class LinesMain {

	public static void main(String[] args) {
		String sentence = "marry\nhad\na\nlittle\nlamb";
		
		Stream<String> lineStream = sentence.lines();
		lineStream.forEach(System.out::println);

	}

}
