package com.itbulls.learnit.javacore.oop.grasp.polymorphism.solution.example2;

public class Order {

    private final String id;
    private OrderStatus status;

    public Order(String id) {
        this.id = id;
        this.status = OrderStatus.NEW;
    }

    public String getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
