package com.itbulls.learnit.javacore.multithreading.executors.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolDemo {
	
	public static void main(String[] args) {
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		
		ForkJoinPool forkJoinPool2 = new ForkJoinPool();
		
		forkJoinPool2.invoke(new DefaultRecursiveAction(32));

	}

}
