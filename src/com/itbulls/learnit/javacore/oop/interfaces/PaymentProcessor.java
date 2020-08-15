package com.itbulls.learnit.javacore.oop.interfaces;

public interface PaymentProcessor {
	
	int RETRY_ATTEPMPTS = 5;
	
	void processPayment(PaymentData payment);
	
	default void someDefaultMethod() {
		System.out.println("This is the default method");
	}
	
	static void someStaticMethod() {
		System.out.println("This is the static method");
	}

}
