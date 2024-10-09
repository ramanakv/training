package trg.threadlocal;

public class NormalTask implements Runnable {
	private Integer localNum;

	@Override
	public void run() {

        // all threads use same variable
		localNum = (int) (Math.random() * 100D);

		System.out.println(Thread.currentThread().getName() + " Initial Value " + localNum);

		try {
			Thread.sleep((long) (Math.random() * 2000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " Final Value " + localNum);
	}
}
