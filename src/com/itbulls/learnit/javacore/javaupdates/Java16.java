package com.itbulls.learnit.javacore.javaupdates;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Java16 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		System.out.println("===== JEP 395 - Records =====");

		User u1 = new User("John", "Smith", "smith@email.com");
		User u2 = new User("John", "Smith", "smith@email.com");
		User u3 = new User("John", "Doe", "doe@email.com");
		System.out.println("User 1: " + u1);
		System.out.println("User 1 equals User 2: " + u1.equals(u2)); // Automatically true
		System.out.println("User 1 equals User 3: " + u1.equals(u3)); // false
		System.out.println("User 1 first name: " + u1.firstName);

//		System.out.println(u1.getFullName());
//		
//		List<User> users = new ArrayList<>();
//		users.add(u1);
//		users.add(u3);
//		System.out.println("Before sorting: " + users);
//		Collections.sort(users);
//		System.out.println("After sorting: " + users);

		System.out.println();
		System.out.println("===== JEP 394: Pattern Matching for instanceof =====");

		// Before Java 16
		Object testString = "test string";
		if (testString instanceof String) {
			String str = (String) testString;
			// other logic goes here
		}

		// Since Java 16
		if (testString instanceof String str) {
			System.out.println(str.length());
			// other logic goes here with str
		}

		Object obj = 12;
		if (obj instanceof Integer i && i > 0) {
			// Use 'i' directly, and it is known to be positive
			System.out.println(i);
		}

		System.out.println();
		System.out.println("===== Invoke Default Methods From Proxy Instances =====");
		Object proxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), 
				new Class<?>[] { DefaultMethodOnProxyDemo.class },
				(prox, method, arguments) -> {
					if (method.isDefault()) {
						return InvocationHandler.invokeDefault(prox, method, arguments);
					}
					return prox;
				});
		Method method = proxy.getClass().getMethod("getText");
		System.out.println(method.invoke(proxy));
		
		
		System.out.println();
		System.out.println("===== Day Period Support =====");
		Locale.setDefault(Locale.US);
		
        LocalTime morningTime = LocalTime.parse("07:30:00");
        LocalTime eveningTime = LocalTime.parse("20:45:00");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h B");
        System.out.println("Morning Time: " + morningTime.format(formatter));
        System.out.println("Evening Time: " + eveningTime.format(formatter));
        
        System.out.println();
		System.out.println("===== Stream.toList Method =====");
        List<String> seasons = Arrays.asList("Winter", "Srping", "Summer", "Fall");
        
        // Before Java 16
        List<String> seasonsUpperCase = seasons.stream().map(String::toUpperCase).collect(Collectors.toList());
        
        // Since Java 16
        List<String> seasonsUpperCase2 = seasons.stream().map(String::toUpperCase).toList();
        System.out.println(seasons);
        System.out.println(seasonsUpperCase);
        System.out.println(seasonsUpperCase2);

	}

	public record User(String firstName, String lastName, String email) {
	}

//	public record User(String firstName, String lastName, String email) implements Comparable<User> {
//		private static int i = 10;
//		// Custom toString method
//		@Override
//		public String toString() {
//			return "User Fields are: (firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ")";
//		}
//		
//		public String getFullName() {
//			return String.format("First Name: %s\tLast Name: %s", this.firstName, this.lastName);
//		}
//
//		@Override
//		public int compareTo(User otherUser) {
//			return this.email.compareToIgnoreCase(otherUser.email);
//		}
//	}

	class Test {
		// Compilation error before Java 16
		static int intValue;

		// Allowed: Static constant variable in an anonymous inner class
		public static final int CONSTANT = 1;
		
		// Compilation error before Java 16
		public static void callStaticMethod() {
			System.out.println("Static method is invoked");
		}
	};
}

interface DefaultMethodOnProxyDemo {
	default String getText() {
		return "Test Text from DefaultMethodOnProxyDemo";
	}
}
