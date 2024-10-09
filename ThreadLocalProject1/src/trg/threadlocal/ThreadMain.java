package trg.threadlocal;

public class ThreadMain {

	public static void main(String[] args) throws InterruptedException {
		
		NormalTask task = new NormalTask();
		
	//	ThreadLocalTask task = new ThreadLocalTask();

		Thread thread1 = new Thread(task, "Thread1");
		Thread thread2 = new Thread(task, "Thread2");
		Thread thread3 = new Thread(task, "Thread3");
		Thread thread4 = new Thread(task, "Thread4");

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

		thread1.join(); // wait for thread 1 to terminate
		thread2.join(); // wait for thread 2 to terminate
		thread3.join(); // wait for thread 3 to terminate
		thread4.join(); // wait for thread 4 to terminate

	}

}
