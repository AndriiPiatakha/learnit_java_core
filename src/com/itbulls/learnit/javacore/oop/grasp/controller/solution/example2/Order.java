package com.itbulls.learnit.javacore.oop.grasp.controller.solution.example2;

import java.util.List;

public class Order {

    private final String customerId;
    private final List<OrderLine> lines;
    private final double totalAmount;

    public Order(String customerId, List<OrderLine> lines, double totalAmount) {
        this.customerId = customerId;
        this.lines = lines;
        this.totalAmount = totalAmount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
