package com.itbulls.learnit.javacore.oop.grasp.controller.solution.example2;

public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController() {
        this.checkoutService =
                new CheckoutService(new OrderRepository(), new OrderFactory());
    }

    public Order handleCheckout(ShoppingCart cart) {
        return checkoutService.checkout(cart);
    }
}
