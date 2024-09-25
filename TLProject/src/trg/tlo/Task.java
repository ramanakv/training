package trg.tlo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Task implements Runnable {
	
	public static Map<String, Integer> map = new HashMap<>();
	
	ThreadLocal<Integer> tloc = new ThreadLocal<Integer>();
	

	@Override
	public void run() {

		int num = map.get(Thread.currentThread().getName());
		tloc.set(num);

		System.out.println(Thread.currentThread().getName() + " Number Initial: " + tloc.get());

		try {
			Thread.sleep((int) (2000));
		} catch (InterruptedException e) {

			throw new RuntimeException();
		}
		Integer i = tloc.get();
		tloc.set(++i);
		
		System.out.println(Thread.currentThread().getName() + " Number final with: " + tloc.get());

	}

}
