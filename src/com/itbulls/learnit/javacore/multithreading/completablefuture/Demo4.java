package com.itbulls.learnit.javacore.multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Demo4 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		var future = CompletableFuture.supplyAsync(() -> {
			System.out.println("Request User ID from external API...");
			return 1234;
		}).thenApply((result) -> {
			System.out.println("Requst total number of purchases in other service by ID...");
			return 150;
		});
		
		System.out.println(future.get());
		
		var es = Executors.newCachedThreadPool();
		CompletableFuture.supplyAsync(() -> {
			System.out.println("Request User ID from external API...");
			return 1234;
		}).thenApplyAsync((result) -> {
			System.out.println("Requst total number of purchases in other service by ID...");
			return 150;
		}, es);
		
		es.shutdown();
		
		
	}

}
