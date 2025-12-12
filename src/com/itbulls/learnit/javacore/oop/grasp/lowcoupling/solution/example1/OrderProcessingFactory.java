package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example1;

//Simple composition root for example/demo purposes:
//wires concrete implementations and returns a low-coupled processor.

public class OrderProcessingFactory {

	public static OrderProcessorLowCoupling createDefaultProcessor() {

		EmailService emailService = new EmailService();
		SmsService smsService = new SmsService();
		NotificationService notificationService = new EmailAndSmsNotificationService(emailService, smsService);

		PaymentGatewayClient paymentGatewayClient = new PaymentGatewayClient();
		PaymentService paymentService = new PaymentGatewayPaymentService(paymentGatewayClient);

		InventoryService inventoryService = new InventoryService();
		StockService stockService = new InventoryStockService(inventoryService);

		DiscountService discountService = new DiscountService();
		DiscountPolicy discountPolicy = new DefaultDiscountPolicy(discountService);

		AuditLogger auditLogger = new AuditLogger();
		AuditService auditService = new ConsoleAuditService(auditLogger);

		return new OrderProcessorLowCoupling(stockService, discountPolicy, paymentService, notificationService,
				auditService);
	}
}
