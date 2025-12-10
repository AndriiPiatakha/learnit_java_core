package com.itbulls.learnit.javacore.oop.grasp.creator.problem.example1;

import java.util.List;

public class Order {

    private final String customerId;
    private final List<OrderLine> lines;

    public Order(String customerId, List<OrderLine> lines) {
        this.customerId = customerId;
        this.lines = lines;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<OrderLine> getLines() {
        return lines;
    }
}
