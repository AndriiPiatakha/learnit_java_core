package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example1;

//Solution example 1:
//OrderProcessorLowCoupling depends on abstractions, not concrete implementations.
//It no longer creates services directly and can be wired from outside.

public class OrderProcessorLowCoupling {

	private final StockService stockService;
	private final DiscountPolicy discountPolicy;
	private final PaymentService paymentService;
	private final NotificationService notificationService;
	private final AuditService auditService;

	public OrderProcessorLowCoupling(StockService stockService, DiscountPolicy discountPolicy,
			PaymentService paymentService, NotificationService notificationService, AuditService auditService) {
		this.stockService = stockService;
		this.discountPolicy = discountPolicy;
		this.paymentService = paymentService;
		this.notificationService = notificationService;
		this.auditService = auditService;
	}

	public void processOrder(Order order) {

		auditService.audit("Starting order processing: " + order.getId());

		double total = 0.0;

		for (OrderLine line : order.getLines()) {
			Product product = line.getProduct();

			boolean reserved = stockService.reserve(product.getId(), line.getQuantity());
			if (!reserved) {
				auditService.audit("Inventory reservation failed for product " + product.getId());
				throw new IllegalStateException("Cannot reserve product " + product.getId());
			}

			total += product.getUnitPrice() * line.getQuantity();
		}

		double discount = discountPolicy.calculateDiscount(order.getCustomer().getId(), total);
		double finalAmount = total - discount;

		auditService.audit("Total=" + total + " discount=" + discount + " finalAmount=" + finalAmount);

		boolean charged = paymentService.charge(order.getCustomer().getId(), finalAmount);
		if (!charged) {
			auditService.audit("Payment failed for order " + order.getId());
			throw new IllegalStateException("Payment failed");
		}

		String message = "Your order " + order.getId() + " is confirmed. Amount: " + finalAmount;
		notificationService.notifyCustomer(order.getCustomer(), message);

		auditService.audit("Order processed successfully: " + order.getId());
	}
}
