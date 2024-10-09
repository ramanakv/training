package trg.tasks;

import java.util.ArrayList;
import java.util.Random;

public class Task implements Runnable {
	ThreadLocal<ArrayList<Integer>> tl = ThreadLocal.withInitial(() -> new ArrayList<Integer>());

	public void run() {
		while (true) {
			int x = new Random().nextInt(100);
			tl.get().add(x);
			for (long i = 0; i < 100000; i++) {
			}
		}

	}
}