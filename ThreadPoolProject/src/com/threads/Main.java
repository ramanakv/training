package com.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
public class Main {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException  {

	    ExecutorService executor = Executors.newFixedThreadPool(3);

		   Future<String> f1 = executor.submit(new Task("Task 1"));


		   
		   executor.submit(new Task("Task 2"));	   
		   executor.submit(new Task("Task 3"));
		   executor.submit(new Task("Task 4"));
		   executor.submit(new Task("Task 5"));
		   executor.submit(new Task("Task 6"));
		   executor.submit(new Task("Task 7"));
		   
		   
		   while(!f1.isDone()) {
			   // do something alse
		   }
		   f1.get();
		   executor.shutdown();  // no more thread are accepted
		   
		
		   
	  }


}
