package com.itbulls.learnit.javacore.oop.grasp.purefabrication.solution.example1;

import java.util.List;

public class Order {

    private final String id;
    private final Customer customer;
    private final List<OrderLine> lines;

    public Order(String id, Customer customer, List<OrderLine> lines) {
        this.id = id;
        this.customer = customer;
        this.lines = lines;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    // Domain behavior stays in the entity
    public double totalAmount() {
        double total = 0.0;
        for (OrderLine line : lines) {
            total += line.getUnitPrice() * line.getQuantity();
        }
        return total;
    }
}
