package com.itbulls.learnit.javacore.oop.grasp.highcohesion.problem.example1;

import java.time.LocalDate;
import java.util.List;

public class Order {

    private final String id;
    private final Customer customer;
    private final List<OrderLine> lines;
    private final LocalDate createdAt;

    public Order(String id, Customer customer, List<OrderLine> lines, LocalDate createdAt) {
        this.id = id;
        this.customer = customer;
        this.lines = lines;
        this.createdAt = createdAt;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}