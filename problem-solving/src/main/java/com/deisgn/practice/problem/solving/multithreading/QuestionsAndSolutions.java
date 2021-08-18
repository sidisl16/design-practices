package com.deisgn.practice.problem.solving.multithreading;

public class QuestionsAndSolutions {

	public void executeAlternative() {
		Thread t1 = new Thread(new Alternative(0));
		Thread t2 = new Thread(new Alternative(1));
		Thread t3 = new Thread(new Alternative(2));

		t1.start();
		t2.start();
		t3.start();
	}

	public void fooBar() {

		FooBar fooBar = new FooBar();
		Thread t1 = new Thread(() -> {
			try {
				fooBar.printFoo();
			} catch (InterruptedException e) {
			}
		});
		Thread t2 = new Thread(() -> {
			try {
				fooBar.printBar();
			} catch (InterruptedException e) {
			}
		});

		t1.start();
		t2.start();
	}

	public static void main(String[] args) {

		QuestionsAndSolutions test = new QuestionsAndSolutions();
		test.fooBar();

	}
}

class Alternative implements Runnable {

	private volatile static int count = 1;
	private int remainder;
	private static final Object mutex = new Object();

	public Alternative(int remainder) {
		super();
		this.remainder = remainder;
	}

	@Override
	public void run() {
		while (count < 100) {
			synchronized (mutex) {
				while (count % 3 != remainder) {
					try {
						mutex.wait();
					} catch (InterruptedException e) {
					}
				}
				if (count <= 100) {
					System.out.println(Thread.currentThread().getName() + " " + count);
					count++;
				}
				mutex.notifyAll();
			}
		}
	}
}

class FooBar {

	private static volatile int count = 1;
	private static volatile boolean running;
	private static final Object mutex = new Object();

	public void printFoo() throws InterruptedException {
		while (count < 10) {
			synchronized (mutex) {
				while (running) {
					mutex.wait();
				}
				System.out.println("Foo ");
				count++;
				running = true;
				mutex.notifyAll();
			}
		}
	}

	public void printBar() throws InterruptedException {
		while (count < 10) {
			synchronized (mutex) {
				while (!running) {
					mutex.wait();
				}
				System.out.println("Bar ");
				count++;
				running = false;
				mutex.notifyAll();
			}
		}
	}
}
