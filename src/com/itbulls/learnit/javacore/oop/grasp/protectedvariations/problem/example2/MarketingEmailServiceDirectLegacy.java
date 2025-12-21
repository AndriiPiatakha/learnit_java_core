package com.itbulls.learnit.javacore.oop.grasp.protectedvariations.problem.example2;

//Problem: our internal logic depends on legacy record fields and legacy concepts (segmentCode).
public class MarketingEmailServiceDirectLegacy {

	private final LegacyCrmApi legacyCrmApi = new LegacyCrmApi();

	public void sendPromo(Customer customer) {
		LegacyCrmContactRecord record = legacyCrmApi.fetchContactByCustomerId(customer.getId());

		// core logic now depends on legacy field names and legacy segmentation rules
		String emailToUse = record.getMailAddress();
		if ("SEG_A".equals(record.getSegmentCode())) {
			System.out.println("Send VIP promo to " + emailToUse);
		} else {
			System.out.println("Send standard promo to " + emailToUse);
		}
	}
}
