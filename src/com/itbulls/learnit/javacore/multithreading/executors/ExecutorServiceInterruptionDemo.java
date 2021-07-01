package com.itbulls.learnit.javacore.multithreading.executors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.mockito.exceptions.misusing.CannotStubVoidMethodWithReturnValue;

public class ExecutorServiceInterruptionDemo {
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService es = Executors.newCachedThreadPool();
		IntStream.range(0, 10).forEach((i) -> {
			es.submit(() -> {
				try {
					TimeUnit.SECONDS.sleep(i);
					System.out.println("Task #" + i + " is completed");
				} catch (InterruptedException e) {
					System.out.println("Task #" + i + " is interrupted");
				}
			});
		});
		
		System.out.println("Shutting down");
		es.shutdown();
		
		// Uncomment line below to see RejectedExecutionException
//		es.submit(() -> System.out.println("new task will throw exception after shutdown"));
		
		try {
		    es.awaitTermination(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			es.shutdownNow();
		}
		
		
	}

}
