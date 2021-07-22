package com.itbulls.learnit.javacore.multithreading.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

import com.itbulls.learnit.javacore.multithreading.synchronizedblock.SynchronizedIncrement;

public class ReentrantLockDemo {

	private static int counter;
	
	private Lock lock = new ReentrantLock();

	public static void main(String[] args) throws InterruptedException {
		var thisInstance = new ReentrantLockDemo();
		var es = Executors.newFixedThreadPool(4);
		IntStream.range(0, 10000).forEach((i) -> es.execute(thisInstance::incrementWithLock));
		terminateExecutorService(es);

		System.out.println(counter);

	}

	public void incrementWithLock() {
		try {
			lock.lock();
			counter++;
		} finally {
			lock.unlock();
		}
	}
	
	public void increment() {
		synchronized(this) {
			counter++;
		}
	}
	
	private static void terminateExecutorService(ExecutorService es) throws InterruptedException {
		es.shutdown();
		es.awaitTermination(3, TimeUnit.SECONDS);
		es.shutdownNow();
	}

}
