package com.itbulls.learnit.javacore.oop.grasp.protectedvariations.solution.example1;

//Simulates a 3rd party SDK. Volatile API surface.
public class PaymentSdkClient {

	public SdkChargeResult createCharge(String apiKey, long amountInCents, String currency) {
		System.out.println("SDK: createCharge apiKey=" + apiKey + " amount=" + amountInCents + " " + currency);
		return new SdkChargeResult(true, "ch_123");
	}
}
