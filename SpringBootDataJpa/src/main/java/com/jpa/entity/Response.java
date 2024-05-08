package com.jpa.entity;

public class Response {
	private String message;

	public Response() {
		
	}
	public Response(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
