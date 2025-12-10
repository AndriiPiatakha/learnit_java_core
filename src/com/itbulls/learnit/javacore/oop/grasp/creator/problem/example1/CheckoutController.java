package com.itbulls.learnit.javacore.oop.grasp.creator.problem.example1;

import java.util.ArrayList;
import java.util.List;

// Anti pattern:
// Controller becomes the "Creator" for Order and OrderLine,
// even though ShoppingCart holds the data and is closer to the domain.

public class CheckoutController {

    public Order checkout(ShoppingCart cart) {
        // Controller is manually constructing all domain objects
        // instead of delegating creation to a domain expert.
        List<OrderLine> orderLines = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();

            OrderLine line = new OrderLine(
                    product.getId(),
                    product.getName(),
                    item.getQuantity(),
                    product.getUnitPrice()
            );

            orderLines.add(line);
        }

        // Controller decides how an Order is created
        // and which data is used.
        return new Order(cart.getCustomerId(), orderLines);
    }
}