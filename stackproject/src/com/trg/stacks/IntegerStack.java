package com.trg.stacks;

public class IntegerStack {
	
	private int stk[];
	int position=0;

	public IntegerStack(int size) {
		stk = new int[size];
		
	}
	
	public void push(int num) throws StackException {
		if(position == stk.length)
			throw new StackException("Stack is full");
		stk[position++]= num;
	}
	
	public int pop() {
		if(position == 0)
			throw new StackException("Stack is empty");
		return stk[--position];
	}
	
	

}
