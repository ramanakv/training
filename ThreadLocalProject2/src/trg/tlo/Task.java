package trg.tlo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Task implements Runnable {

	public static Map<String, Integer> map = new HashMap<>();

	ThreadLocal<Integer> tloc = new ThreadLocal<Integer>();

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		int num = map.get(name);
		tloc.set(num);

		System.out.println(name + " Number Initial: " + tloc.get());

		try {
			Thread.sleep((int) (2000));
		} catch (InterruptedException e) {

			throw new RuntimeException();
		}
		Integer i = tloc.get();
		tloc.set(++i);

		System.out.println(name + " Number final with: " + tloc.get());

	}

}
