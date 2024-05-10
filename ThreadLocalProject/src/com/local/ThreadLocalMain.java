package com.local;

public class ThreadLocalMain {

	public static void main(String[] args) {
		ThreadLocal<Integer> tl = ThreadLocal.withInitial(()->100);
		
		NumberThread nt = new NumberThread(tl);
		
		new Thread(nt,"Thread 1").start();
		new Thread(nt,"Thread 2").start();
		new Thread(nt,"Thread 3").start();
		new Thread(nt,"Thread 4").start();
		new Thread(nt,"Thread 5").start();
	}

}
