
import java.util.ArrayList;
import java.util.List;

public class Main1 {

	public static void main(String[] args) {

		System.out.println("Main: " + Thread.currentThread());

		Thread t1 = new Thread(new Task1());
		t1.start();
		
		for (int i = 100; i <= 200; i = i+20) {
			System.out.println("Main thread output: " + i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

class Task1 implements Runnable {

	@Override
	public void run() {
		System.out.println("TNumbers: " + Thread.currentThread());
		for (int i = 1; i <= 10; i++) {
			System.out.println("Task1 Output: " + i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}