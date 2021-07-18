package com.itbulls.learnit.javacore.multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Demo2 {

	private static final double DEFAULT_PRICE = 9.99;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println(calculateAsync().get());
		
	}
	
	public static Future<Double> calculateAsync() throws InterruptedException {
	    CompletableFuture<Double> completableFuture = new CompletableFuture<>();

	    var es = Executors.newCachedThreadPool();
		Future<Double> future = es.submit(() -> {
			System.out.println("request to a server has been sent...");
			Double result = null;
			TimeUnit.SECONDS.sleep(5);
			return result;
		});
	    
		es.shutdown();
		es.awaitTermination(2, TimeUnit.SECONDS);
		
		if (future.isDone()) {
			return future;
		} else {
			completableFuture.complete(DEFAULT_PRICE);
			return completableFuture;
		}
	}
}
