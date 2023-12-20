package com.itbulls.learnit.javacore.javaupdates.java9;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.MultiResolutionImage;
import java.io.File;
import java.io.IOException;
import java.lang.StackWalker.StackFrame;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Java9 {

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		
		System.out.println("===== Collection factory methods: List.of(...); Set.of(...); Map.of(...); =====");
		List<String> fruits = List.of("Apple", "Banana", "Orange");
		System.out.println(fruits);
		
		Set<Integer> numbers = Set.of(1, 2, 3, 4, 5);
        System.out.println(numbers);
        
        Map<String, Integer> ageMap = Map.of("Alice", 25, "Bob", 30, "Charlie", 22);
        System.out.println(ageMap);
        
        System.out.println();
        System.out.println("===== Stream API Improvements: takeWhile, dropWhile, ofNullable, iterate with condition =====");
        List<Integer> result = Stream.of(1, 2, 3, 4, 5, 6).takeWhile(n -> n < 4).collect(Collectors.toList());
        System.out.println(result);  // Output: [1, 2, 3]
        
        result = Stream.of(1, 2, 3, 4, 5, 6).dropWhile(n -> n < 4).collect(Collectors.toList());
        System.out.println(result);  // Output: [4, 5, 6]
        
        Integer value = 42;
        Stream<Integer> stream = Stream.ofNullable(value);
        stream.forEach(System.out::println);  // Output: 42
        
        Optional<Integer> optionalValue = Optional.ofNullable(null);

        result = optionalValue
                        .stream()
                        .flatMap(Stream::ofNullable)
                        .collect(Collectors.toList());
        System.out.println(result);
        
        Stream.iterate(1, n -> n < 10, n -> n * 2)
        		.forEach(System.out::println);
        
        System.out.println();
        System.out.println("===== Multi-Resolution Image API =====");
     // Assume you have a MultiResolutionImage for your app logo
        MultiResolutionImage logo = getLogo();

        // Get the best logo version for a specific screen size
        double screenWidth = 800.0;
        double screenHeight = 600.0;
        Image bestLogoVersion = logo.getResolutionVariant(screenWidth, screenHeight);
        System.out.println("Best Logo Version - " + bestLogoVersion);
        
        JFrame frame = new JFrame("Logo Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     // Create a JLabel to display the selected image
        JLabel imageLabel = new JLabel(new ImageIcon(bestLogoVersion));

        // Add the label to the frame
        frame.getContentPane().add(imageLabel);

        // Pack and display the frame
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        // Get a list of all logo versions
        List<Image> allLogoVersions = logo.getResolutionVariants();
        System.out.println("All Logo Versions amount: " + allLogoVersions.size());
        
        System.out.println();
        System.out.println("===== Stack-walker API =====");
        // Create a StackWalker for the current thread
        StackWalker stackWalker = StackWalker.getInstance();

        // Walk the stack frames and print information
        List<String> frameInfoList = stackWalker.walk(frames -> {
            List<String> frameInfo = frames.map(StackFrame::toString)
                                          .collect(Collectors.toList());

            System.out.println("Stack Frames:");
            frameInfo.forEach(System.out::println);
            return frameInfo;
        });
        
        System.out.println();
        System.out.println("===== this.getClass().getPackageName() =====");
        System.out.println(Java9.class.getPackageName());
        
        System.out.println();
        System.out.println("===== Process API Updates =====");
        ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe");
        Process process = processBuilder.start();
        ProcessHandle processHandle = process.toHandle();

        // Get process information
        System.out.println("Process ID: " + processHandle.pid());
        System.out.println("Parent Process: " + processHandle.parent().get());
        System.out.println("Is process alive: " + processHandle.isAlive());
        
        processHandle.onExit().thenAccept(ph -> System.out.println("Process exited: " + ph));
//        processHandle.destroy(); // Gracefully terminate the process
//        processHandle.destroyForcibly(); // Forcefully terminate the process

        System.out.println();
        System.out.println("===== new methods in CompletableFuture API (delay, timeout, etc.)");
        CompletableFuture<Void> delayedFuture = CompletableFuture.runAsync(() -> {
            // Some asynchronous operation
            System.out.println("Async operation");
        }, CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS));

        // ------ 
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running operation
            try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
            return "Result";
        });
        CompletableFuture<String> resultFuture = future.orTimeout(2, TimeUnit.SECONDS);
        try {
        	resultFuture.get();
        } catch (InterruptedException | ExecutionException e) {
        	System.out.println("Timeout Exception caught: " + e.getCause().getClass());
        }
        
        // -----
        
        future = CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running operation
        	 try {
 				TimeUnit.SECONDS.sleep(5);
 			} catch (InterruptedException e) {
 				throw new RuntimeException(e);
 			}
             return "Result";
        });
        
        resultFuture = future.completeOnTimeout("Default", 2, TimeUnit.SECONDS);
        System.out.println(resultFuture.get());
        

        // -----
        Executor defaultExecutor = new CompletableFuture().defaultExecutor();
        System.out.println(defaultExecutor.getClass());
        future = CompletableFuture.supplyAsync(() -> "Result");
        future.thenAcceptAsync(r -> System.out.println(r), defaultExecutor);
        
        // -----
        CompletableFuture<String> incompleteFuture = new CompletableFuture().newIncompleteFuture();
        // Perform some asynchronous operation (e.g., fetching data from a remote service)
        // and complete the CompletableFuture when the operation is done
        performAsyncOperation(incompleteFuture);
        // Wait for the result and handle it
        String resultString = incompleteFuture.join();
        System.out.println("Result: " + resultString);

        // -----
        CompletableFuture<String> original = CompletableFuture.supplyAsync(() -> "Original Result");
        CompletableFuture<String> copy = original.copy();
        
        // -----
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        // Using minimalCompletionStage to obtain a CompletionStage view
        CompletionStage<String> completionStage = completableFuture.minimalCompletionStage();
        // Interact with libraries or methods expecting CompletionStage
        processWithCompletionStage(completionStage);
        
        // ------
        CompletableFuture<String> f = new CompletableFuture<>();
        CompletableFuture<String> completedFuture = f.completeAsync(() -> "Result");

        
	}
	
	private static void processWithCompletionStage(CompletionStage<String> completionStage) {
        // Use the CompletionStage API
        completionStage.thenApply(String::toUpperCase)
                      .thenAccept(System.out::println)
                      .exceptionally(ex -> {
                          System.err.println("Exception: " + ex);
                          return null;
                      });
    }
	
	private static void performAsyncOperation(CompletableFuture<String> future) {
        // Simulate an asynchronous operation
        new Thread(() -> {
            try {
                // Simulate a delay
                TimeUnit.SECONDS.sleep(2);

                // Complete the CompletableFuture with a result
                future.complete("Async Operation Result");
            } catch (InterruptedException e) {
                // Handle exception (if needed)
                future.completeExceptionally(e);
            }
        }).start();
    }
	
	
	
	private static MultiResolutionImage getLogo() {
        // Load resolution variants of the logo using Toolkit
        Image logo1x = Toolkit.getDefaultToolkit().getImage("resources" + File.separator + "java9" + File.separator + "logo.png");
        Image logo2x = Toolkit.getDefaultToolkit().getImage("resources" + File.separator + "java9" + File.separator + "logo_2x.png");
        Image logo3x = Toolkit.getDefaultToolkit().getImage("resources" + File.separator + "java9" + File.separator + "logo_3x.png");

        // Create a list of resolution variants
        List<Image> resolutionVariants = new ArrayList<>();
        resolutionVariants.add(logo1x);
        resolutionVariants.add(logo2x);
        resolutionVariants.add(logo3x);

        // Return a MultiResolutionImage instance
        return new SimpleMultiResolutionImage(resolutionVariants);
    }

    // Simple implementation of MultiResolutionImage
    private static class SimpleMultiResolutionImage implements MultiResolutionImage {
        private final List<Image> resolutionVariants;
        public SimpleMultiResolutionImage(List<Image> resolutionVariants) {
            this.resolutionVariants = resolutionVariants;
        }

        @Override
        public Image getResolutionVariant(double destImageWidth, double destImageHeight) {
            // In a real implementation, you would choose the best variant based on the destination size
            // For simplicity, let's return the first variant
            return resolutionVariants.get(0);
        }

        @Override
        public List<Image> getResolutionVariants() {
            return resolutionVariants;
        }
    }

}
