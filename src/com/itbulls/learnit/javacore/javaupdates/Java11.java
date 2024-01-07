package com.itbulls.learnit.javacore.javaupdates;

import java.io.IOException;
import java.net.CookiePolicy;
import java.net.CookieManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.*;

public class Java11 {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("===== HTTP Client Demo =====");
		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		System.out.println("* Sending Get request synchronously: ");
		HttpRequest request = HttpRequest.newBuilder()
		        .uri(URI.create("https://google.com"))
		        .build();

		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println("Response Code: " + response.statusCode());
		System.out.println("Response Body: " + response.body());
		
		System.out.println();
		System.out.println("* Sending Get request asynchronously: ");
		CompletableFuture<HttpResponse<String>> future = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

		future.thenAccept(response2 -> {
		    System.out.println("Response Code: " + response2.statusCode());
		    System.out.println("Response Body: " + response2.body());
		});

		future.join(); // Wait for the request to complete
		
		System.out.println();
		System.out.println("* Customizing Request");
		HttpRequest requestCustomized = HttpRequest.newBuilder()
		        .uri(URI.create("https://example.com"))
		        .header("User-Agent", "Java 11 HttpClient")
		        .timeout(Duration.ofSeconds(10))
		        .build();


		
		System.out.println();
		System.out.println("* Cookie management demo: ");
		CookieManager cookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
		HttpClient httpClient2 = HttpClient.newBuilder()
		        .cookieHandler(cookieManager)
		        .build();

		HttpRequest request2 = HttpRequest.newBuilder()
		        .uri(URI.create("https://www.google.com"))
		        .build();
		HttpResponse<String> response3 = httpClient2.send(request2, HttpResponse.BodyHandlers.ofString());
		 // Print the cookies received
        cookieManager.getCookieStore().getCookies().forEach(cookie -> {
            System.out.println("Received Cookie: " + cookie);
        });
        
        
        System.out.println();
		System.out.println("* Configure redirects: ");
        HttpClient httpClient3 = HttpClient.newBuilder()
                .followRedirects(Redirect.ALWAYS)
                .build();
        HttpResponse<String> response4 = httpClient3.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println("Response Code: " + response4.statusCode());
		System.out.println("Response Body: " + response4.body());
		
		
		System.out.println();
		System.out.println("===== New String methods (repeat, isBlank, strip, stripLeading, stripTrailing, lines) =====");
		System.out.println("* repeat() demo: ");
		String repeated = "Java ".repeat(3);
		System.out.println(repeated); // Output: Java Java Java
		
		System.out.println();
		System.out.println("* isBlank() demo: ");
		String emptyString = "";
		String whitespaceString = "   ";
		String nonEmptyString = "Java";

		System.out.println(emptyString.isBlank()); // Output: true
		System.out.println(whitespaceString.isBlank()); // Output: true
		System.out.println(nonEmptyString.isBlank()); // Output: false
		System.out.println(whitespaceString.isEmpty()); // Output: false

		System.out.println();
		System.out.println("* strip(), stripLeading(), stripTrailing() demo: ");
		String stringWithSpaces = "   Java 11   ";
		String strippedString = stringWithSpaces.strip();
		System.out.println(strippedString); // Output: Java 11
		
		String stringWithNonBreakingSpace = "\u2000 abc \u2000";
		String strippedString2 = stringWithNonBreakingSpace.strip();
		String trimmedString = stringWithNonBreakingSpace.trim();

		System.out.println("Original String: '" + stringWithNonBreakingSpace + "'");
		System.out.println("Stripped String: '" + strippedString2 + "'");
		System.out.println("Trimmed String: '" + trimmedString + "'");
		
		
		System.out.println();
		System.out.println("* lines() demo: ");
		String multilineString = "Java\n11\nis\nawesome";
		multilineString.lines().forEach(System.out::println);
		
		
		System.out.println();
		System.out.println("===== New Files methods (readString, writeString) =====");
		Path filePath = Path.of("test_text.txt");
        try {
            String content = Files.readString(filePath);
            System.out.println("File Content:\n" + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Files.writeString(Paths.get("Java_11_test.txt"), "Java 11 - Demo Lesson", 
        		StandardOpenOption.CREATE, StandardOpenOption.DSYNC, StandardOpenOption.APPEND);
        
        System.out.println();
        System.out.println("===== Collection toArray(IntFunction) method ");
        List<String> stringList = new ArrayList<>();
        stringList.add("Java");
        stringList.add("Python");
        stringList.add("C++");
        
        String[] stringArray = stringList.toArray(size -> new String[size]);
        stringArray = stringList.toArray(String[]::new);
        
        System.out.println(Arrays.toString(stringArray));
        
        System.out.println();
        System.out.println("===== Predicate.not() ======");
        
        // Original predicate to check if a number is greater than 5
        Predicate<Integer> isGreaterThan5 = n -> n > 5;

        // Using the not method to create a new predicate that negates the original predicate
        Predicate<Integer> isNotGreaterThan5 = Predicate.not(isGreaterThan5);

        // Testing the predicates
        System.out.println("isGreaterThan5: " + isGreaterThan5.test(8));       // true
        System.out.println("isNotGreaterThan5: " + isNotGreaterThan5.test(8)); // false
        
        
        System.out.println();
        System.out.println("===== JEP 323: Local-Variable Syntax for Lambda Parameters ======");
        // Before Java 11
        BiFunction<Integer, Integer, Integer> add = (Integer a, Integer b) -> a + b;
        
        // Since Java 11
        BiFunction<Integer, Integer, Integer> add2 = (var a, var b) -> a + b;
        
        // Like I do :)
        BiFunction<Integer, Integer, Integer> add3 = (a, b) -> a + b;

        
        System.out.println();
        System.out.println("===== JEP 181: Nest-Based Access Control ======");
        // Using reflection to get nest host and members
        getNestInformation(NestExample.class);
        getNestInformation(NestExample.InnerClass1.class);
        getNestInformation(NestExample.InnerClass2.class);
	}
	
	private static void getNestInformation(Class<?> clazz) {
        System.out.println("Class: " + clazz.getName());

        // Get the nest host
        Class<?> nestHost = clazz.getNestHost();
        System.out.println("Nest Host: " + (nestHost != null ? nestHost.getName() : "None"));

        // Get the nest members
        Class<?>[] nestMembers = clazz.getNestMembers();
        System.out.println("Nest Members: " + Arrays.toString(nestMembers));

        System.out.println();
    }

}


class NestExample {
    private int privateField;

    public class InnerClass1 {
        private void accessPrivateField() {
            // InnerClass1 can access privateField directly
            System.out.println(privateField);
        }
    }

    public class InnerClass2 {
        private void accessPrivateField() {
            // InnerClass2 can access privateField directly
            System.out.println(privateField);
        }
    }
}

