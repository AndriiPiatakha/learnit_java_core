package com.itbulls.learnit.javacore.multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Demo8 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Retrieving weight.");
		CompletableFuture<Double> weightInKgFuture = getWeight();

		System.out.println("Retrieving height.");
		CompletableFuture<Double> heightInCmFuture = getHeight();
		

		System.out.println("Calculating Body Mass Index.");
		CompletableFuture<Double> combinedFuture = weightInKgFuture
		        .thenCombine(heightInCmFuture, (weightInKg, heightInCm) -> {
		    Double heightInMeter = heightInCm / 100;
		    return weightInKg / (heightInMeter * heightInMeter);
		});

		System.out.println("BMI is - " + combinedFuture.get());
	}

	
	
	private static CompletableFuture<Double> getWeight() {
		CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		    }
		    return 72.0;
		});
		return weightInKgFuture;
	}

	private static CompletableFuture<Double> getHeight() {
		CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		    }
		    return 183.5;
		});
		return heightInCmFuture;
	}

}
