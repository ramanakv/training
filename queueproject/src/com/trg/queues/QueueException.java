package com.trg.queues;

public class QueueException  extends RuntimeException{
	
	private String message;
	
	public QueueException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
