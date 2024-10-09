package trg.tasks;


// slow running project with 2 threads
// executed to monitor in Visual VM
public class Main {
public static void main(String[] args) throws InterruptedException {
	Task task = new Task();
	Thread t1 =new Thread(task,"Thread 1");
	Thread t2 =new Thread(task,"Thread 2");
	
	t1.start();
	t2.start();
	t1.join();
	t2.join();
	
}
}
