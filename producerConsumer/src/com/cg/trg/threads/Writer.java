package com.cg.trg.threads;

import com.cg.trg.threads.store.MessageBox;

public class Writer extends Thread {
	private MessageBox box;

	public Writer(MessageBox box) {
		super();
		this.box = box;
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			box.storeMessage("Message NO: " + i);
			System.out.println("Stored Message No: " + i);
			try {
				Thread.sleep((int) (Math.random() * 2000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
