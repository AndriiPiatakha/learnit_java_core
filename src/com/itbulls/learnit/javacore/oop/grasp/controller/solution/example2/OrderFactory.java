package com.itbulls.learnit.javacore.oop.grasp.controller.solution.example2;

import java.util.ArrayList;
import java.util.List;

public class OrderFactory {

    public Order createOrder(ShoppingCart cart) {

        List<OrderLine> lines = new ArrayList<>();
        double total = 0.0;

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();

            OrderLine line = new OrderLine(
                    product.getId(),
                    product.getName(),
                    item.getQuantity(),
                    product.getUnitPrice()
            );

            lines.add(line);
            total += line.lineTotal();
        }

        return new Order(cart.getCustomerId(), lines, total);
    }
}