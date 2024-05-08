
public class Main2 {
	public static void main(String[] args) {

		System.out.println("Main: " + Thread.currentThread());

		Thread t[] = new Thread[25];  // platform threads

		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(new Task2(i));
			t[i].start();   // we are placing the thread in queue
		}
	}
}


class Task2 implements Runnable {

	int id;
	
	public Task2(int id) {
		super();
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Thread"+id +" : " + Thread.currentThread());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
