package com.itbulls.learnit.javacore.oop.grasp.controller.solution.example2;

public class CheckoutPage {

    private final CheckoutController controller = new CheckoutController();

    public void onCheckoutSubmit(ShoppingCart cart) {

        Order order = controller.handleCheckout(cart);

        System.out.println("Checkout completed. Total: " + order.getTotalAmount());
        System.out.println("Redirecting to thank-you page...");
    }
}
