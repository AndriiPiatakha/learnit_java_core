package com.itbulls.learnit.javacore.oop.grasp.protectedvariations.solution.example1;

//Simple wiring for demo (composition root).
public class AppWiring {

	public static CheckoutService createCheckoutService() {
		PaymentSdkClient sdkClient = new PaymentSdkClient();

		PaymentGateway gateway = new SdkPaymentGatewayAdapter(sdkClient, "HARDCODED_KEY", "USD");

		return new CheckoutService(gateway);
	}
}