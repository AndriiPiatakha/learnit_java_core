package com.itbulls.learnit.javacore.oop.grasp.protectedvariations.solution.example1;

//Core depends on abstraction (Protected Variations + Dependency Inversion).
//No SDK details here.

public class CheckoutService {

	private final PaymentGateway paymentGateway;

	public CheckoutService(PaymentGateway paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

	public void checkout(Order order) {
		PaymentResult result = paymentGateway.charge(order.getTotalAmount());

		if (!result.isSuccess()) {
			throw new IllegalStateException("Payment failed for order " + order.getId());
		}

		System.out.println("Checkout OK. paymentRef=" + result.getReference());
	}
}
