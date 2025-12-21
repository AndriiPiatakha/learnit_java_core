package com.itbulls.learnit.javacore.oop.grasp.polymorphism.solution.example2;

public class OrderStatusProcessorPolymorphic {

    private final OrderStatusHandlerRegistry registry;

    public OrderStatusProcessorPolymorphic(OrderStatusHandlerRegistry registry) {
        this.registry = registry;
    }

    public void handle(Order order) {
        OrderStatusHandler handler = registry.getFor(order.getStatus());
        handler.handle(order);
    }
}
