package com.itbulls.learnit.javacore.multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Demo12 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			int i = 5;
			i /= 0;
			return i++;
		}).handle((result, exc) -> {
			if (exc != null) {
				System.out.println("Exception happend during the execution: " + exc.getClass());
				System.out.println("Exception is caused by: " + exc.getCause());
			}
			return result;
		});
		
		System.out.println(future.get());
		
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
			int i = 5;
			i /= 0;
			return i++;
		}).exceptionally((exc) -> {
			if (exc != null) {
				System.out.println("Exception happend during the execution: " + exc.getClass());
				System.out.println("Exception is caused by: " + exc.getCause());
			}
			return 10; // default value
		});
		
		System.out.println(future2.get());
	}

}
