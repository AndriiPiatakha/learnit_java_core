package com.itbulls.learnit.javacore.multithreading;

import java.util.concurrent.TimeUnit;

public class DaemonThreadDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		var t1 = new Thread(() -> {
			while (true) {
				try {
					TimeUnit.MILLISECONDS.sleep(500);
					System.out.println("Daemon is working");
				} catch (InterruptedException e) {
					
				}
			
			}
		});
		
//		t1.setDaemon(true);
		t1.start();
		
		TimeUnit.SECONDS.sleep(2);
		System.out.println("Main thread finished");
		
	}
}
