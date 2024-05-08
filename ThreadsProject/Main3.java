
public class Main3 {

	public static void main(String[] args) {

		System.out.println("Main: " + Thread.currentThread());

		Thread t[] = new Thread[50];

		for (int i = 0; i < t.length; i++) {
			t[i] =  Thread.ofVirtual().unstarted(new Task3(i));
			
			t[i].start(); // we are placing the thread in queue
		}
		

		for (int i = 0; i < t.length; i++) {
			try {
				t[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
	}

}


class Task3 implements Runnable {

	int id;

	public Task3(int id) {
		super();
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Before sleep Thread" + id + " : " + Thread.currentThread());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("After sleep Thread" + id + " : " + Thread.currentThread());
	}

}
