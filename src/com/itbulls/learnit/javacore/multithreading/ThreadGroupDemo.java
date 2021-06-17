package com.itbulls.learnit.javacore.multithreading;

import java.util.concurrent.TimeUnit;

public class ThreadGroupDemo {

	public static void main(String[] args) throws InterruptedException {
		
		ThreadGroup threadGorup = new ThreadGroup("group");
		
		var t0 = new Thread(threadGorup, ThreadGroupDemo::execute);
		var t1 = new Thread(threadGorup, ThreadGroupDemo::execute);
		var t2 = new Thread(threadGorup, ThreadGroupDemo::execute);
		var t3 = new Thread(threadGorup, ThreadGroupDemo::execute);
		var t4 = new Thread(threadGorup, ThreadGroupDemo::execute);

		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		TimeUnit.SECONDS.sleep(2);
		
		threadGorup.interrupt();
	}
	
	public static void execute() {
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.println(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				break;
			}
			
		}
	}
	
}
