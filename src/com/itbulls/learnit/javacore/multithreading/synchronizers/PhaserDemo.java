package com.itbulls.learnit.javacore.multithreading.synchronizers;

import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class PhaserDemo {

	private static final int NUMBER_OF_THREADS = 2;
	private static Phaser phaser = new Phaser();

	public static void main(String[] args) throws InterruptedException {
		var es = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

		System.out.println("Phase before tasks execution: " + phaser.getPhase());
		IntStream.range(0, NUMBER_OF_THREADS).forEach(i -> es.submit(new Task(phaser)));
		es.shutdown();
		
		es.awaitTermination(1, TimeUnit.SECONDS);
		System.out.println("Parties after all threads are de-registered: " 
				+ phaser.getRegisteredParties());
		
	}

	private static class Task implements Runnable {
		private Phaser phaser;

		public Task(Phaser phaser) {
			this.phaser = phaser;
			this.phaser.register();
		}

		@Override
		public void run() {
			System.out.println("Arrived in thread: " + Thread.currentThread().getName());
			System.out.println("Arrival phase number: " + phaser.arriveAndAwaitAdvance());
			try {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println("getPhase(): " + phaser.getPhase());
				System.out.println("Arrived in thread: " + Thread.currentThread().getName());
				System.out.println("Arrival phase number: " + phaser.arriveAndAwaitAdvance());
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println("getPhase(): " + phaser.getPhase());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			phaser.arriveAndDeregister();
		}
	}

}
