package com.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	public static void main(String[] args)  {

	    ExecutorService executor = Executors.newFixedThreadPool(3);

		   executor.submit(new Task("Task 1"));
		   executor.submit(new Task("Task 2"));	   
		   executor.submit(new Task("Task 3"));
		   executor.submit(new Task("Task 4"));
		   executor.submit(new Task("Task 5"));
		   executor.submit(new Task("Task 6"));
		   executor.submit(new Task("Task 7"));
		   executor.shutdown();

	  }


}
