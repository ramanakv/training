package trg.tlo;

import java.util.Map;

//different values supplied to different threads
// using Map in Task.
// threads will pickup the data based on their name from map

public class ThreadLocalMain {

	public static void main(String[] args) throws InterruptedException {
		Task task = new Task();

		task.map.put("Thread 1", 100);
		task.map.put("Thread 2", 200);
		task.map.put("Thread 3", 300);

		
		Thread t1 = new Thread(task, "Thread 1");
		Thread t2 = new Thread(task, "Thread 2");
		Thread t3 = new Thread(task, "Thread 3");

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();

	}

}
