package com.threads;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {
	private final String name;

	public Task(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		for (int i = 0; i < 5; i++) {
			Thread.sleep(5000);
			System.out.println(name + " came out");
		}
		System.out.println("Task [" + name + "] executed on : " + LocalDateTime.now().toString());
		return null;
	}
	
}