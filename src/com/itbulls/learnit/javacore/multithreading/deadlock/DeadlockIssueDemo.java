package com.itbulls.learnit.javacore.multithreading.deadlock;

import java.util.concurrent.TimeUnit;

public class DeadlockIssueDemo {
	
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	
	public static void main(String[] args) {
		
		new Thread(() -> {
			synchronized (lock1) {
				System.out.println("Lock1 is captured");
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {}
				
				synchronized (lock2) {
					System.out.println("This block will never be executed");
				}
			}
		}).start();
		
		new Thread(() -> {
			synchronized (lock2) {
				System.out.println("Lock2 is captured");
				synchronized (lock1) {
					System.out.println("This block will never be executed");
				}
			}
		}).start();
		
	}

}
