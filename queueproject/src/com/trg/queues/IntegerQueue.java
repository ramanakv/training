package com.trg.queues;

public class IntegerQueue {

	private int queue[];
	private int elements = 0;
	private int start = 0;
	private int end = 0;

	public IntegerQueue(int size) {
		super();
		queue = new int[size];
	}

	public void enqueue(int x) {
		if(elements == queue.length)
			throw new QueueException("Queue is full");
		queue[end++]=x;
		if(end == queue.length)
			end=0;
		elements++;

	}

	public int dequeue() {
		if(elements==0)
			throw new QueueException("Queue is empty");
		elements--;
		int num = queue[start++];
		if(start == queue.length)
			start = 0;
		return num;

	}

}
