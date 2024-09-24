package com.cg.trg.threads;

import com.cg.trg.threads.store.MessageBox;

public class Reader extends Thread {
	private MessageBox box;

	public Reader(MessageBox box) {
		super();
		this.box = box;
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			String message = box.getMessage();
			System.out.println("Picked up " + message);
			try {
				Thread.sleep((int) (Math.random() * 2000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
