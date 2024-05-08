
public class Main4 {
	public static void main(String[] args) {

		int taskCount = 100000;
		
		Thread t[] = new Thread[taskCount];

		long start = System.currentTimeMillis();
		for (int i = 0; i < taskCount; i++) {
		//	t[i] = Thread.ofVirtual().unstarted(() -> {	});
			
			t[i] = Thread.ofVirtual().unstarted(new Task4());
			
		//	t[i] = new Thread(new Task4());   // old way of creating platform thread
			
			t[i].start(); // we are placing the thread in queue
		}

		for (int i = 0; i < taskCount; i++) {
			try {
				t[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end - start;
		
		System.out.println("Time taken by " + taskCount + " threads is "+ duration);

	}

}

class Task4 implements Runnable{

	@Override
	public void run() {
		
	}
	
}
