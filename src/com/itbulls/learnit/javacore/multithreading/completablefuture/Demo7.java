package com.itbulls.learnit.javacore.multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo7 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<CompletableFuture<Double>> result = getUserDetailById(125)
				.thenApply(user -> getCreditRating(user));
		
		System.out.println(result.get().get());
		
		CompletableFuture<Double> result2 = getUserDetailById(125)
				.thenCompose(user -> getCreditRating(user));
		System.out.println(result2.get());
	}
	
	private static CompletableFuture<String> getUserDetailById(int userId) {
		return CompletableFuture.supplyAsync(() -> {
			return "user details string";
		});	
	}

	private static CompletableFuture<Double> getCreditRating(String userDetails) {
		return CompletableFuture.supplyAsync(() -> {
			return 110.98;
		});
	}

}
