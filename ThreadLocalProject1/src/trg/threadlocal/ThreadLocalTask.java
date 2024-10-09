package trg.threadlocal;

public class ThreadLocalTask implements Runnable {
	private ThreadLocal<Integer> localNum = new ThreadLocal<>();

	@Override
	public void run() {

		localNum.set((int) (Math.random() * 100D));

		System.out.println(Thread.currentThread().getName() + " Initial Value " + localNum.get());

		try {
			Thread.sleep((long) (Math.random() * 2000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " Final Value " + localNum.get());

	}
}
