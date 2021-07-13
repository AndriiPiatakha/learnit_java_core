package com.itbulls.learnit.javacore.multithreading.executors.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolDemo2 {
	
	public static void main(String[] args) {
		var pool = new ForkJoinPool();
		
		var result = pool.invoke(new DefaultRecursiveTask(40));
		System.out.println("Result: " + result);
		
	}

}
