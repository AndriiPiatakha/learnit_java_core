package com.itbulls.learnit.javacore.oop.grasp.indirection.solution.example1;

//UI is now thin. It depends on the controller only (indirection),
//not on all concrete services.

public class CheckoutPage {

 private final CheckoutController controller;

 public CheckoutPage(CheckoutController controller) {
     this.controller = controller;
 }

 public void onPayClicked(String customerEmail, String productId, int qty, double unitPrice) {

     CheckoutRequest request = new CheckoutRequest(customerEmail, productId, qty, unitPrice);
     CheckoutResult result = controller.checkout(request);

     System.out.println("UI: " + result.getMessage());
 }
}
