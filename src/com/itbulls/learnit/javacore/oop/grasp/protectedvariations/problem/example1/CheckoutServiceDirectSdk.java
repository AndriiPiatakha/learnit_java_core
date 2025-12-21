package com.itbulls.learnit.javacore.oop.grasp.protectedvariations.problem.example1;

//Problem: business flow depends on SDK details - apiKey, 
// 							cents conversion, currency string, SDK result.
public class CheckoutServiceDirectSdk {

	private final PaymentSdkClient sdkClient = new PaymentSdkClient();

	public void checkout(Order order) {
		String apiKey = "HARDCODED_KEY"; // volatile config in core
		long cents = (long) (order.getTotalAmount() * 100); // repeated conversion logic
		String currency = "USD"; // provider specific detail in core

		SdkChargeResult result = sdkClient.createCharge(apiKey, cents, currency);

		if (!result.isSuccess()) {
			throw new IllegalStateException("Payment failed for order " + order.getId());
		}

		System.out.println("Checkout OK. chargeId=" + result.getChargeId());
	}
}