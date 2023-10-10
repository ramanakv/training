package com.trg.queues;

import java.util.ArrayList;

public class ListIntegerQueue {

	private ArrayList<Integer> queue = new ArrayList<Integer>();

	public void enqueue(int x) {
		queue.add(x);
	}

	public int dequeue() {
		if (queue.isEmpty())
			throw new QueueException("Queue is empty");
		return queue.remove(0);

	}
}
