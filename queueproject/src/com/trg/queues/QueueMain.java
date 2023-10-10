package com.trg.queues;

public class QueueMain {

	public static void main(String[] args) {
		
	//	IntegerQueue queue = new IntegerQueue(5);
		
		ListIntegerQueue queue = new ListIntegerQueue();
		queue.enqueue(34);
		queue.enqueue(21);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());   // exeption Queue is empty

	}

}
