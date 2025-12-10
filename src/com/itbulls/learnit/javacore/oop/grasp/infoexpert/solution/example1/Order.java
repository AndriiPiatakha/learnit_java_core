package com.itbulls.learnit.javacore.oop.grasp.infoexpert.solution.example1;

import java.util.List;

public class Order {

    private List<OrderLine> lines;

    // maybe later: customer, shippingAddress, etc.

    public Order(List<OrderLine> lines) {
        this.lines = lines;
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    // Information Expert: Order knows its lines, so it calculates total
    public double calculateTotal() {
        double total = 0.0;
        for (OrderLine line : lines) {
            total += line.calculateLineTotal();
        }

        total += calculateShippingFee(total);
        return total;
    }

    // Order is also the natural expert about how shipping is applied to itself
    private double calculateShippingFee(double subtotal) {
        if (subtotal < 50) {
            return 5.99;
        }
        return 0.0;
    }
}