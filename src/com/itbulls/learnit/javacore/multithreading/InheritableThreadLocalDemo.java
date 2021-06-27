package com.itbulls.learnit.javacore.multithreading;

import java.util.concurrent.TimeUnit;

public class InheritableThreadLocalDemo {

	
	private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
	private static InheritableThreadLocal<String> inheritableThreadLocal 
															= new InheritableThreadLocal<>();
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			System.out.println("***** Thread #1 *****");
			threadLocal.set("---Thread #1 - ThreadLocal---");
			inheritableThreadLocal.set("---Thread #1 - InheritableThreadLocal---");

			System.out.println(threadLocal.get());
			System.out.println(inheritableThreadLocal.get());

			Thread childThread = new Thread(() -> {
				System.out.println("***** ChildThread *****");
				System.out.println(threadLocal.get());
				System.out.println(inheritableThreadLocal.get());
			});
			childThread.start();
		});

		thread1.start();

		Thread thread2 = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
			}

			System.out.println("**** Thread #2 *****");
			System.out.println(threadLocal.get());
			System.out.println(inheritableThreadLocal.get());
		});
		thread2.start();
	}
}