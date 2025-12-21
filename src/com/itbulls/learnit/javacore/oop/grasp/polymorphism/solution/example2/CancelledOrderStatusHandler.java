package com.itbulls.learnit.javacore.oop.grasp.polymorphism.solution.example2;

public class CancelledOrderStatusHandler implements OrderStatusHandler {

    @Override
    public void handle(Order order) {
        System.out.println("Order " + order.getId() + " is CANCELLED: refund process");
    }
}
