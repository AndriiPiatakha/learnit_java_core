package com.itbulls.learnit.javacore.optional;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		createOptionalExample();
		valueRelatedMethodsExample();
		conditionalActionsExample();
		getExample();
		orElseExample();
		filterExample();
		mapExample();
		flatMapExample();
	}

	private static void flatMapExample() {
		User person = new User("Yegor", 1990);
	    Optional<User> personOptional = Optional.of(person);

	    Optional<Optional<String>> nameOptionalWrapped  
	      						= personOptional.map(User::getName);
	    Optional<String> nameOptional  
	      						= nameOptionalWrapped.orElseThrow(IllegalArgumentException::new);
	    String name = nameOptional.orElse("");
	    
	    System.out.println(name);

	    
	    name = personOptional
	      .flatMap(User::getName)
	      .orElse("");
	    System.out.println(name);
	}

	private static void mapExample() {
		Optional<User> optional = Optional.of(new User("Yegor", 1990));
		
		Integer yearOfBirth = optional.map(user -> user.getYearOfBirth())
				.filter(year -> year >= 1960)
				.filter(year -> year <= 2000)
				.orElse(null);
		System.out.println("map() and filter() demo: " + yearOfBirth);
	}

	private static void filterExample() {
		Optional<String> optional = Optional.of("Andrey Pyatakha");
		System.out.println("filter() demo: " + optional
					.filter(fullName -> fullName.contains("Andrey"))
				.orElse("No required name found"));
		
		System.out.println("filter() demo: " + optional
				.filter(fullName -> fullName.contains("Dima"))
			.orElse("No required name found"));
	}

	private static void orElseExample() {
		Optional<String> optional = Optional.empty();
		System.out.println("orElse(): " + optional.orElse("default string"));
		System.out.println("orElseGet(): " + optional.orElseGet(() -> "default string"));

		System.out.println("orElse(): " + optional.orElse(OptionalDemo.getDefaultString()));
		System.out.println("orElseGet(): " + optional.orElseGet(OptionalDemo::getDefaultString));

		try {
			optional.orElseThrow(); // throws NoSuchElementException
			optional.orElseThrow(() -> new RuntimeException());
		} catch (Exception e) {

		}
	}

	private static String getDefaultString() {
		return "default string";
	}

	private static void getExample() {
		Optional<String> optional = Optional.of("Learn IT University");
		System.out.println("get(): " + optional.get());

		optional = Optional.empty();
		try {
			optional.get();
		} catch (NoSuchElementException e) {
			System.out.println("get(): no element found");
		}

		if (optional.isPresent()) {
			System.out.println(optional.get());
		}
	}

	private static void conditionalActionsExample() {
		Optional<String> optional = Optional.of("Learn IT University");
		optional.ifPresent(string -> System.out.println("ifPresent(): " + string));

		optional = Optional.empty();
		optional.ifPresentOrElse(string -> System.out.println(string),
				() -> System.out.println("ifPresentOrElse(): No value found"));

	}

	private static void valueRelatedMethodsExample() {
		Optional<String> optional = Optional.of("Learn IT University");
		System.out.println("isPresent(): " + optional.isPresent());
		System.out.println("isEmpty():" + optional.isEmpty());

		System.out.println("======================");

		optional = Optional.ofNullable(null);
		System.out.println("isPresent(): " + optional.isPresent());
		System.out.println("isEmpty(): " + optional.isEmpty());

	}

	private static void createOptionalExample() {
		Optional<String> emptyOptional = Optional.empty();

		String string = "Learn IT University";
		Optional<String> optional = Optional.of(string);

		string = null;
		Optional<String> opt = Optional.ofNullable(string);

	}
	
	
	private static class User {
		
		private String name;
		private int yearOfBirth;
		
		public User(String name, int yearOfBirth) {
			this.name = name;
			this.yearOfBirth = yearOfBirth;
		}

		public int getYearOfBirth() {
			return this.yearOfBirth;
		}
		
		public Optional<String> getName() {
			return Optional.ofNullable(this.name);
		}
	}

}
