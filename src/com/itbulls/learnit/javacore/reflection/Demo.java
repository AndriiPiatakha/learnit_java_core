package com.itbulls.learnit.javacore.reflection;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Demo {
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Class userClass = new User().getClass();
		
		System.out.println("Get class name: " + userClass.getName());
		
		Field[] fields = userClass.getDeclaredFields();
		
		System.out.println("===== Get Fields Names =====");
		Arrays.stream(fields).forEach(field -> System.out.println(field.getName()));
	
		System.out.println("===== Get Fields Type =====");
		Arrays.stream(fields).forEach(field -> System.out.println(field.getGenericType()));
		
		System.out.println("===== Does Field have private modifier? =====");
		Arrays.stream(fields).forEach(field -> 
				System.out.println(Modifier.isPrivate(field.getModifiers())));
		
		System.out.println("Get package name: " + userClass.getPackageName());
		
		System.out.println("Get super class: " + userClass.getSuperclass());
		
		System.out.println("===== Get Interfaces =====");
		Class[] interfaces = userClass.getInterfaces();
		Arrays.stream(interfaces).forEach(i -> System.out.println(i.getName()));
		
		userClass = Class.forName("com.itbulls.learnit.javacore.reflection.Demo$User");
		
		System.out.println("===== Get Constructors =====");
		Constructor<User>[] constructors = userClass.getDeclaredConstructors();
		System.out.println("Number of constructors: " + constructors.length);
		Arrays.stream(constructors).forEach(constructor -> System.out.println(constructor.getName()));
		
		System.out.println("===== Get Private Constructor =====");
		Constructor<User> privateConstructor = userClass.getDeclaredConstructor(String.class);
		System.out.println(privateConstructor);
		
		System.out.println("===== Get Methods =====");
		Method[] methods = userClass.getDeclaredMethods();
		Arrays.stream(methods).forEach(method -> System.out.println(method.getName()));
		
		System.out.println("===== Get Method =====");
		Method method = userClass.getMethod("mergeTwoUserAccounts", User.class);
		System.out.println(method);
		
		System.out.println("===== New Instance =====");
		Constructor<User> defaultConstructor = userClass.getConstructor();
		User newInstance = defaultConstructor.newInstance();
		System.out.println(newInstance);
		System.out.println(privateConstructor.newInstance("newdefault@email.com"));
		
		System.out.println("===== Field initalization =====");
		Field firstNameField = userClass.getDeclaredField("firstName");
		firstNameField.setAccessible(true);
		firstNameField.set(newInstance, "Sergey");
		System.out.println(newInstance);
		
		System.out.println("===== Static Field initalization =====");
		Field idField = userClass.getDeclaredField("id");
		idField.setAccessible(true);
		idField.set(null, 20);
		System.out.println(newInstance);
		
		System.out.println("===== Read Value from Field +====");
		System.out.println(firstNameField.get(newInstance));
		System.out.println(idField.get(null));
		
		System.out.println("===== Method invocation =====");
		Method privateMethod = userClass.getDeclaredMethod("doSomething", String.class);
		privateMethod.setAccessible(true);
		privateMethod.invoke(newInstance, "Test String");
		
		System.out.println("===== Static Method invocation =====");
		Method privateStaticMethod = userClass.getDeclaredMethod("doSomethingStatic", String.class);
		privateMethod.setAccessible(true);
		privateStaticMethod.invoke(null, "Test String");
		
	}
	
	private static class User implements Serializable, Cloneable {
		private static int id = 0;
		
		private String firstName;
		private String lastName;
		private String email;
		
		static {
			id++;
		}
		
		public User() {
			this("default@user.com");
		}
		
		private User(String defaultEmail) {
			this.email = defaultEmail;
		}
		
		public void printFullNameToConsole() {
			System.out.println(firstName + " " + lastName);
		}
		
		public double calculateTotalAmountSpentInOnlineStore() {
			return 1125.65; // some dummy value 
		}
		
		public void mergeTwoUserAccounts(User anotherUser) {
			// merging order history and other data of two accounts
		}
		
		private void doSomething(String someString) {
			System.out.println("Private method invocation with argument: " + someString);
		}
		
		private static void doSomethingStatic(String someString) {
			System.out.println("Private static method invocation with argument: " + someString);
		}

		@Override
		public String toString() {
			return "User [id=" + id +", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
		}

	
	}

}
