package com.itbulls.learnit.javacore.generics;

public class GenericDemo3<T> {
	
	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	public static void main(String[] args) {
		GenericDemo3<Integer> integerBox = new GenericDemo3<Integer>();
		GenericDemo3<String> stringBox = new GenericDemo3<>();

		integerBox.set(10);
//		integerBox.set("ten"); // compilation error
		
		stringBox.set("Hello World");
//		stringBox.set(10); // compilation error
		
		Integer integer = integerBox.get();
		String string = stringBox.get();

		System.out.printf("Integer Value : %d\n\n", integer);
		System.out.printf("String Value : %s\n", string);
	}
}