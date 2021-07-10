package com.itbulls.learnit.javacore.multithreading.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CachedThreadPoolDemo {

	public static void main(String[] args) {
		ThreadPoolExecutor es = (ThreadPoolExecutor) Executors.newCachedThreadPool();

		IntStream.range(0, 4).forEach(i -> {
			es.submit(() -> {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		});

		es.shutdown();

		System.out.println("Pool size: " + es.getPoolSize());
		System.out.println("Queue size: " + es.getQueue().size());
	}

}
