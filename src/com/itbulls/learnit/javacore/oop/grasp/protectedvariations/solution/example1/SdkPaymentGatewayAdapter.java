package com.itbulls.learnit.javacore.oop.grasp.protectedvariations.solution.example1;

//Adapter: isolates SDK details from the core.
//If SDK changes (API keys, cents, currency, new DTOs), only this class changes.

public class SdkPaymentGatewayAdapter implements PaymentGateway {

	private final PaymentSdkClient sdkClient;
	private final String apiKey;
	private final String currency;

	public SdkPaymentGatewayAdapter(PaymentSdkClient sdkClient, String apiKey, String currency) {
		this.sdkClient = sdkClient;
		this.apiKey = apiKey;
		this.currency = currency;
	}

	@Override
	public PaymentResult charge(double amount) {
		long cents = (long) Math.round(amount * 100.0);

		SdkChargeResult sdkResult = sdkClient.createCharge(apiKey, cents, currency);

		if (!sdkResult.isSuccess()) {
			return new PaymentResult(false, null);
		}
		return new PaymentResult(true, sdkResult.getChargeId());
	}
}
