package com.itbulls.learnit.javacore.multithreading.executors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAllDemo {
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService es = Executors.newCachedThreadPool();
		List<Callable<String>> tasks = new ArrayList<>(Arrays.asList(
					() -> "task #1",
					() -> "task #2",
					() -> "task #3"
				));
		
		List<Future<String>> futures = es.invokeAll(tasks);
		
		futures.stream().map(future -> {
			try {
				return future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return "";
		}).forEach(System.out::println);
		
	}

}
