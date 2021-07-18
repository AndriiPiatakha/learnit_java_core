package com.itbulls.learnit.javacore.multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo3 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> futureResult = CompletableFuture.supplyAsync(() -> "Hello");
		System.out.println(futureResult.get());
	}

}
