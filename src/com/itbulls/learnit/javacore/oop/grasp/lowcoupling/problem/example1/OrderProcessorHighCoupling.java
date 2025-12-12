package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.problem.example1;

import java.util.List;

//Problem example 1:
//OrderProcessor is tightly coupled to many concrete services.
//It creates them directly and knows too many details about how they work.

public class OrderProcessorHighCoupling {

	// Direct concrete dependencies
	private final EmailService emailService = new EmailService();
	private final SmsService smsService = new SmsService();
	private final PaymentGatewayClient paymentGatewayClient = new PaymentGatewayClient();
	private final InventoryService inventoryService = new InventoryService();
	private final DiscountService discountService = new DiscountService();
	private final AuditLogger auditLogger = new AuditLogger();

	public void processOrder(Order order) {

		auditLogger.log("Starting order processing: " + order.getId());

		// Tight coupling to calculation logic, discount service, inventory
		double total = 0.0;
		for (OrderLine line : order.getLines()) {
			Product product = line.getProduct();
			boolean reserved = inventoryService.reserve(product.getId(), line.getQuantity());
			if (!reserved) {
				auditLogger.log("Inventory reservation failed for product " + product.getId());
				throw new IllegalStateException("Cannot reserve product " + product.getId());
			}
			total += product.getUnitPrice() * line.getQuantity();
		}

		double discount = discountService.calculateDiscount(order.getCustomer().getId(), total);
		double finalAmount = total - discount;

		auditLogger.log("Total=" + total + " discount=" + discount + " finalAmount=" + finalAmount);

		boolean charged = paymentGatewayClient.charge(order.getCustomer().getId(), finalAmount);
		if (!charged) {
			auditLogger.log("Payment failed for order " + order.getId());
			throw new IllegalStateException("Payment failed");
		}

		// Tight coupling to notification mechanisms
		String email = order.getCustomer().getEmail();
		String phone = order.getCustomer().getPhone();

		emailService.sendEmail(email, "Your order " + order.getId() + " is confirmed",
				"Thank you for your purchase. Amount: " + finalAmount);

		smsService.sendSms(phone, "Order " + order.getId() + " confirmed. Amount: " + finalAmount);

		auditLogger.log("Order processed successfully: " + order.getId());
	}
}