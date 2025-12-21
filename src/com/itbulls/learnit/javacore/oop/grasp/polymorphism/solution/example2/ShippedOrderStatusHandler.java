package com.itbulls.learnit.javacore.oop.grasp.polymorphism.solution.example2;

public class ShippedOrderStatusHandler implements OrderStatusHandler {

    @Override
    public void handle(Order order) {
        System.out.println("Order " + order.getId() + " is SHIPPED: tracking enabled");
    }
}