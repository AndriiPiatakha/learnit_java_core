package com.itbulls.learnit.javacore.oop.grasp.indirection.problem.example1;

//Problem: UI layer knows too much and calls multiple concrete services directly.
//No indirection layer (controller/facade/use case). Hard to change, hard to test.

public class CheckoutPage {

 private final PaymentGatewayClient paymentGateway = new PaymentGatewayClient();
 private final InventoryService inventoryService = new InventoryService();
 private final EmailSender emailSender = new EmailSender();
 private final AnalyticsClient analyticsClient = new AnalyticsClient();

 public void onPayClicked(String customerEmail, String productId, int qty, double unitPrice) {

     boolean reserved = inventoryService.reserve(productId, qty);
     if (!reserved) {
         System.out.println("UI: Out of stock");
         return;
     }

     double amount = unitPrice * qty;
     boolean charged = paymentGateway.charge(amount);

     if (!charged) {
         System.out.println("UI: Payment failed");
         inventoryService.release(productId, qty);
         return;
     }

     emailSender.send(customerEmail, "Order confirmed", "Thanks! Amount: " + amount);
     analyticsClient.trackEvent("checkout_success");

     System.out.println("UI: Checkout completed");
 }
}