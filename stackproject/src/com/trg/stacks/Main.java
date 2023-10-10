package com.trg.stacks;

public class Main {

	public static void main(String[] args) {
		// IntegerStack stack = new IntegerStack(12);
		ListIntegerStack stack = new ListIntegerStack();
		for (int i = 1; i < 5; i++) {
			stack.push(i);
			System.out.println("pushed " + i);
		}

		int a = stack.pop();
		System.out.println(a);

		int b = stack.pop();
		System.out.println(b);

		int c = stack.pop();
		System.out.println(c);
	}

}
