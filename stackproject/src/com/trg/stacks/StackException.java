package com.trg.stacks;

public class StackException extends RuntimeException {

	String message;
	
	public StackException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
