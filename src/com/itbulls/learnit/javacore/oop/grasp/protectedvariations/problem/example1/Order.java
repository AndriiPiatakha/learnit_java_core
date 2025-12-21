package com.itbulls.learnit.javacore.oop.grasp.protectedvariations.problem.example1;

public class Order {

    private final String id;
    private final double totalAmount;

    public Order(String id, double totalAmount) {
        this.id = id;
        this.totalAmount = totalAmount;
    }

    public String getId() {
        return id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
