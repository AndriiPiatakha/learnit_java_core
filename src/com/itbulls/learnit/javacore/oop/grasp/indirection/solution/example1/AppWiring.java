package com.itbulls.learnit.javacore.oop.grasp.indirection.solution.example1;

//Simple manual wiring for demo purposes (composition root).
public class AppWiring {

 public static CheckoutPage createCheckoutPage() {
     PaymentGatewayClient paymentGateway = new PaymentGatewayClient();
     InventoryService inventoryService = new InventoryService();
     EmailSender emailSender = new EmailSender();
     AnalyticsClient analyticsClient = new AnalyticsClient();

     CheckoutController controller = new CheckoutController(
             paymentGateway,
             inventoryService,
             emailSender,
             analyticsClient
     );

     return new CheckoutPage(controller);
 }
}
