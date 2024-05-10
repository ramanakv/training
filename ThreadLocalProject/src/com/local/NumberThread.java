package com.local;

public class NumberThread implements Runnable{


	ThreadLocal<Integer> localvalue;
	
	
	
	public NumberThread(ThreadLocal<Integer> localvalue) {
		super();
		this.localvalue = localvalue;
	}


	@Override
	public void run() {
		System.out.println("Thread "+ Thread.currentThread().getName()+ " initial value "+localvalue.get());
		
		try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		localvalue.set((int)(Math.random()*500));
		
		System.out.println("Thread "+ Thread.currentThread().getName()+ "  new value "+localvalue.get());
	}

}
