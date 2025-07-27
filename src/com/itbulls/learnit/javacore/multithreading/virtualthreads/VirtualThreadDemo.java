package com.itbulls.learnit.javacore.multithreading.virtualthreads;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class VirtualThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== DEMO: Virtual Threads in Java 21 ===");

        // --- 1. Basic Hello World using Thread.startVirtualThread() ---
        Thread vThread = Thread.startVirtualThread(() -> {
            System.out.println("Hello from a virtual thread (Thread.startVirtualThread)");
        });

        // Wait for the virtual thread to finish
        vThread.join();

        // --- 2. Preferred API: Executors.newVirtualThreadPerTaskExecutor() ---
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            // Submit a simple task
            Future<String> result = executor.submit(() -> {
                System.out.println("Hello from a virtual thread in ExecutorService!");
                return "Task completed";
            });

            // Wait and print result
            System.out.println("Result: " + result.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // --- 3. Parallel task processing example ---
        int numberOfTasks = 100;

        System.out.println("\nRunning " + numberOfTasks + " tasks in parallel using virtual threads...");
        long startTime = System.nanoTime();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
        	List<Future<?>> futures = IntStream.range(0, numberOfTasks)
        	        .<Future<?>>mapToObj(i -> executor.submit(() -> {
        	            System.out.println("Task #" + i + " is running on " + Thread.currentThread());
        	            // Simulate some work
        	            try {
        	                Thread.sleep(100);           // Simulate work
        	            } catch (InterruptedException e) {
        	                Thread.currentThread().interrupt();
        	            }
        	        }))
        	        .toList();
            
            for (Future<?> future : futures) {
                try {
                    future.get(); // block until task completes
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        long endTime = System.nanoTime();
        double virtualThreadsTime = (endTime - startTime) / 1_000_000.0;
		System.out.printf("Finished %d tasks in %.2f ms%n",
                numberOfTasks, virtualThreadsTime);
        
        startTime = System.nanoTime();
        int cpus = Runtime.getRuntime().availableProcessors();
        try (ExecutorService executor = Executors.newFixedThreadPool(cpus)) {
        	List<Future<?>> futures = IntStream.range(0, numberOfTasks)
        	        .<Future<?>>mapToObj(i -> executor.submit(() -> {
        	            System.out.println("Task #" + i + " is running on " + Thread.currentThread());
        	            // Simulate some work
        	            try {
        	                Thread.sleep(100);           // Simulate work
        	            } catch (InterruptedException e) {
        	                Thread.currentThread().interrupt();
        	            }
        	        }))
        	        .toList();
            
            for (Future<?> future : futures) {
                try {
                    future.get(); // block until task completes
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        endTime = System.nanoTime();
        double platformThreadsTime = (endTime - startTime) / 1_000_000.0;
		System.out.printf("Finished %d tasks in %.2f ms%n",
                numberOfTasks, platformThreadsTime);
		System.out.println("=== Result ===");
		System.out.println("Virtual Threads Time: " + virtualThreadsTime);
		System.out.println("Platform Threads Time: " + platformThreadsTime);

        // --- 4. Memory usage (rough check) ---
     
    }
}
