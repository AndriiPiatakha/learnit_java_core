package com.itbulls.learnit.javacore.javaupdates;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java10 {

	public static void main(String[] args) {

		System.out.println("===== Local Variable Type inference =====");
		// Before Java 10
		List<String> names = new ArrayList<String>();
		// With Local Variable Type Inference in Java 10
		var namesVar = new ArrayList<String>();

//		namesVar = new LinkedList<String>();
//		namesVar = new ArrayList<Integer>();
		namesVar = new ArrayList<String>();
		
		// Before Java 10
		List<String> names2 = Arrays.asList("Alice", "Bob", "Charlie");
		names.forEach((String name) -> System.out.println(name));

//		// In Java 10, you still need to specify the type for lambda expression parameters
//		List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
//		names.forEach((var name) -> System.out.println(name));
//		// compiler error: 'var' is not allowed here
		
		
//		// Error: cannot use 'var' on variable without initializer
//		var n;
//		// Error: variable initializer is 'null'
//		var emptyList = null;
		
//		var arr = { "One", "Two", "Three" }; // error: array initializer needs an explicit target-type

	
		System.out.println();
		System.out.println("===== orElseThrow() in Optional =====");
		Optional<String> optionalValue = Optional.of("Hello, World!");
        // If value is present, print it; otherwise, throw a custom exception
        String result = optionalValue.orElseThrow(() -> new IllegalStateException("Value is not present"));
        System.out.println(result);
        
        System.out.println();
        System.out.println("===== APIs for Creating Unmodifiable Collections =====");
        List<String> originalList = Arrays.asList("apple", "banana", "orange");
        List<String> unmodifiableList = List.copyOf(originalList);
        
        Set<String> originalSet = new HashSet<>(Arrays.asList("apple", "banana", "orange"));
        Set<String> unmodifiableSet = Set.copyOf(originalSet);
        
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("apple", 1);
        originalMap.put("banana", 2);
        originalMap.put("orange", 3);

        Map<String, Integer> unmodifiableMap = Map.copyOf(originalMap);

        List<String> unmodifiableList2 = Stream.of("apple", "banana", "orange")
                .collect(Collectors.toUnmodifiableList());

        Set<String> unmodifiableSet2 = Stream.of("apple", "banana", "orange")
                .collect(Collectors.toUnmodifiableSet());

        Map<String, Integer> unmodifiableMap2 = Stream.of("apple", "banana", "orange")
                .collect(Collectors.toUnmodifiableMap(Function.identity(), String::length));

	}

	// ======
	// Before Java 10
	public void processData(List<String> data) {
		// method implementation
	}
	// In Java 10, you still need to specify the type for method parameters
//	public void processData(var data) {
//	    // compiler error: 'var' is not allowed here
//	}
	// ======

}

//In Java 10, you still need to specify the type for member variables
class MyClassJava10 {
	private List<String> myList = new ArrayList<>();
//	private var myList = new ArrayList<String>();
	// compiler error: 'var' is not allowed here

	// other class members
}



