package com.itbulls.learnit.javacore.multithreading.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo2 {

	public static void main(String[] args) throws InterruptedException {
		var es = Executors.newScheduledThreadPool(4);

		es.scheduleAtFixedRate(() -> {
			System.out.println("Hello");
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {}
		}, 500, 1000, TimeUnit.MILLISECONDS);

		es.awaitTermination(7, TimeUnit.SECONDS);
		es.shutdownNow();

		System.out.println("====================================");

		var es2 = Executors.newScheduledThreadPool(4);

		es2.scheduleWithFixedDelay(() -> {
			System.out.println("Hello");
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {}
		}, 500, 1000, TimeUnit.MILLISECONDS);

		es2.awaitTermination(7, TimeUnit.SECONDS);
		es2.shutdownNow();
	}

}
