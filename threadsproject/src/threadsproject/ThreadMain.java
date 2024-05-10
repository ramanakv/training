package threadsproject;

public class ThreadMain {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new NumberTask(),"Number Thread");
		
		Thread t2 = new Thread(new MessageTask(), "Message Thread");
		
		t1.start();
		t2.start();
		
System.out.println("Job done");
	}

}
