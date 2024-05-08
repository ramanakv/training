package com.jpa.exceptions;

public class DuplicateEmployeeException  extends RuntimeException{
	
	public DuplicateEmployeeException(String msg) {
		super(msg);
	}
}
