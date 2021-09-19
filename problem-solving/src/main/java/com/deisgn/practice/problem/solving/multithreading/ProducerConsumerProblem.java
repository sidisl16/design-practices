package com.deisgn.practice.problem.solving.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class ProducerConsumerProblem {

	private Queue<Integer> queue = new LinkedList<>();
	private static int SIZE = 5;

	public void producer(int i) {

		while (queue.size() == SIZE) {
			synchronized (queue) {
				try {
					System.out.println("Queue is full.");
					queue.wait();
				} catch (InterruptedException e) {
				}
			}
		}

		synchronized (queue) {
			System.out.println("Adding item into queue." + i);
			queue.add(i);
			queue.notifyAll();
		}
	}

	public void consumer() {
		synchronized (queue) {
			while (queue.isEmpty()) {
				System.out.println("Queue is empty.");
				try {
					queue.wait();
				} catch (InterruptedException e) {
				}
			}
		}
		synchronized (queue) {
			System.out.println(queue.poll());
			queue.notifyAll();
		}
	}

	public static void main(String[] args) {
		final ProducerConsumerProblem obj = new ProducerConsumerProblem();

		Thread producer = new Thread(() -> IntStream.range(0, 10).forEach(i -> obj.producer(i)));

		Thread consumer = new Thread(() -> {
			while (true)
				obj.consumer();
		});

		producer.start();
		consumer.start();
	}

}
