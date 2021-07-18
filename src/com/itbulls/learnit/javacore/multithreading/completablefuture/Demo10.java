package com.itbulls.learnit.javacore.multithreading.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Demo10 {

	public static void main(String[] args) {
		List<String> messages = Arrays.asList("a", "b", "c");
		List<CompletableFuture> futures = messages.stream()
				.map(msg -> CompletableFuture.completedFuture(msg)
						.thenApply(s -> delayedUpperCase(s)))
				.collect(Collectors.toList());
		
		CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
				.whenComplete((v, th) -> {
			futures.forEach(cf -> System.out.println( cf.getNow(null)) );
		});
	}
	
	static String delayedUpperCase(String s) {
        randomSleep();
        return s.toUpperCase();
    }

    static void randomSleep() {
        try {
        	TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
