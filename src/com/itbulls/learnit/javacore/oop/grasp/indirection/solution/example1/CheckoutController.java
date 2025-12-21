package com.itbulls.learnit.javacore.oop.grasp.indirection.solution.example1;

//Indirection: UI calls a controller (use case) instead of talking to services directly.
//The controller coordinates workflow and isolates UI from technical details.

public class CheckoutController {

 private final PaymentGatewayClient paymentGateway;
 private final InventoryService inventoryService;
 private final EmailSender emailSender;
 private final AnalyticsClient analyticsClient;

 public CheckoutController(PaymentGatewayClient paymentGateway,
                           InventoryService inventoryService,
                           EmailSender emailSender,
                           AnalyticsClient analyticsClient) {
     this.paymentGateway = paymentGateway;
     this.inventoryService = inventoryService;
     this.emailSender = emailSender;
     this.analyticsClient = analyticsClient;
 }

 public CheckoutResult checkout(CheckoutRequest request) {

     boolean reserved = inventoryService.reserve(request.getProductId(), request.getQuantity());
     if (!reserved) {
         return CheckoutResult.fail("Out of stock");
     }

     double amount = request.totalAmount();
     boolean charged = paymentGateway.charge(amount);

     if (!charged) {
         inventoryService.release(request.getProductId(), request.getQuantity());
         return CheckoutResult.fail("Payment failed");
     }

     emailSender.send(
             request.getCustomerEmail(),
             "Order confirmed",
             "Thanks! Amount: " + amount
     );

     analyticsClient.trackEvent("checkout_success");

     return CheckoutResult.ok("Checkout completed");
 }
}