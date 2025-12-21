package com.itbulls.learnit.javacore.oop.grasp.protectedvariations.solution.example2;

//Core depends on our abstraction (CrmGateway), not on legacy record details.

public class MarketingEmailService {

	private final CrmGateway crmGateway;

	public MarketingEmailService(CrmGateway crmGateway) {
		this.crmGateway = crmGateway;
	}

	public void sendPromo(Customer customer) {
		CustomerProfile profile = crmGateway.loadProfile(customer.getId());

		if (profile.getSegment() == CustomerProfile.Segment.VIP) {
			System.out.println("Send VIP promo to " + profile.getEmail());
		} else {
			System.out.println("Send standard promo to " + profile.getEmail());
		}
	}
}
