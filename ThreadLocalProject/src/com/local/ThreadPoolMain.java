package com.local;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolMain {

	public static void main(String[] args) {

		ThreadLocal<Integer> tl = ThreadLocal.withInitial(() -> 100);

		NumberThread nt = new NumberThread(tl);

		ExecutorService pool = Executors.newFixedThreadPool(3);
		
		pool.submit(nt);
		pool.submit(nt);
		pool.submit(nt);
		pool.submit(nt);
		pool.submit(nt);
		pool.submit(nt);
		pool.submit(nt);
		pool.submit(nt);
		
		
		pool.shutdown();
		

	}

}
