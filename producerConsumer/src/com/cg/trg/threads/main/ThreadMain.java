package com.cg.trg.threads.main;

import com.cg.trg.threads.Reader;
import com.cg.trg.threads.Writer;
import com.cg.trg.threads.store.MessageBox;

public class ThreadMain {

	public static void main(String[] args) throws InterruptedException {
	
		MessageBox box = new MessageBox();
		Thread rt = new Reader(box);
		Thread wt = new Writer(box);

		rt.start();
		wt.start();
		
		rt.join();
		wt.join();
		
		System.out.println("Application completed");
	}

}
