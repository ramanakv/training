package com.boot.beans;

public class ErrorMessage {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorMessage=" + message;
	}
	
	

}
