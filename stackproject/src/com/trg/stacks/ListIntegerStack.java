package com.trg.stacks;

import java.util.ArrayList;

public class ListIntegerStack {

	private ArrayList<Integer> stk = new ArrayList<Integer>();

	public void push(int num) throws StackException {
		stk.add(num);
	}

	public int pop() {
		if (stk.isEmpty())
			throw new StackException("Stack is empty");
		return stk.remove(stk.size()-1);
	}

}
