package com.itbulls.learnit.javacore.oop.grasp.protectedvariations.solution.example2;

//Wiring for demo.
public class AppWiring {

	public static MarketingEmailService createMarketingEmailService() {
		LegacyCrmApi legacyCrmApi = new LegacyCrmApi();
		CrmGateway gateway = new LegacyCrmAntiCorruptionLayer(legacyCrmApi);

		return new MarketingEmailService(gateway);
	}
}