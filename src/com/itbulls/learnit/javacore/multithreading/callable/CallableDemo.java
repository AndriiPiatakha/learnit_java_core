package com.itbulls.learnit.javacore.multithreading.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		
		ExecutorService es = Executors.newCachedThreadPool();
		Future<Integer> future = es.submit(() -> 1 + 1);
		
		System.out.println(future.get(10, TimeUnit.SECONDS));
		
	}

}
