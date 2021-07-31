package com.itbulls.learnit.javacore.multithreading.hw;

import java.util.concurrent.TimeUnit;

public class Task1 {

	public static void main(String[] args) throws InterruptedException {
		var t1 = new Thread(new Task());
		var t2 = new DefaultThread();
		var t3 = new Thread(() -> {
			while (true) {
				System.out.println(Thread.currentThread().getName());
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					break;
				}
			}
		});
		var t4 = new Thread(Task1::printThreadName);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		TimeUnit.SECONDS.sleep(5);
		t1.interrupt();

	}

	private static void printThreadName() {
		while (true) {
			System.out.println(Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				break;
			}
		}
	}

	private static class Task implements Runnable {

		@Override
		public void run() {
			while (true) {
				System.out.println(Thread.currentThread().getName());
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					break;
				}
			}
		}

	}

	private static class DefaultThread extends Thread {
		@Override
		public void run() {
			while (true) {
				System.out.println(Thread.currentThread().getName());
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}

}
