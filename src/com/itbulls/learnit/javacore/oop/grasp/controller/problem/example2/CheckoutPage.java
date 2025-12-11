package com.itbulls.learnit.javacore.oop.grasp.controller.problem.example2;

import java.util.ArrayList;
import java.util.List;

// Problem example 2:
// UI layer (page) directly performs all orchestration and domain work,
// no dedicated controller exists.

public class CheckoutPage {

    private final OrderRepository orderRepository = new OrderRepository();

    // Simulated "render" or "submit" method called from UI framework
    public void onCheckoutSubmit(ShoppingCart cart) {

        // UI calculates totals
        double total = 0.0;
        List<OrderLine> lines = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();

            double lineTotal = product.getUnitPrice() * item.getQuantity();
            total += lineTotal;

            OrderLine line = new OrderLine(
                    product.getId(),
                    product.getName(),
                    item.getQuantity(),
                    product.getUnitPrice()
            );

            lines.add(line);
        }

        // UI constructs domain object directly
        Order order = new Order(cart.getCustomerId(), lines, total);

        // UI persists order directly
        orderRepository.save(order);

        // UI decides what to show next
        System.out.println("Checkout completed on UI, redirecting to thank-you page...");
    }
}