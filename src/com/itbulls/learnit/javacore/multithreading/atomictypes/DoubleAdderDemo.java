package com.itbulls.learnit.javacore.multithreading.atomictypes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.DoubleAdder;

public class DoubleAdderDemo {
	
	private static DoubleAdder doubleSum = new DoubleAdder();

	public static void main(String[] args) throws InterruptedException {
		List<Thread> allThreads = new ArrayList<>();
		int numberOfIncrements = 10000;

		for (int i = 0; i < numberOfIncrements; i++) {
			var t = new Thread(DoubleAdderDemo::increment);
			allThreads.add(t);
			t.start();
		}

		for (Thread thread : allThreads) {
			thread.join();
		}

		System.out.println(doubleSum.doubleValue());

	}

	public static void increment() {
		doubleSum.add(1.1);
	}

}
