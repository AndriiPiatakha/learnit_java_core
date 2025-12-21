package com.itbulls.learnit.javacore.oop.grasp.polymorphism.solution.example2;

import java.util.EnumMap;
import java.util.Map;

public class OrderStatusHandlerRegistry {

    private final Map<OrderStatus, OrderStatusHandler> handlers =
            new EnumMap<>(OrderStatus.class);

    public OrderStatusHandlerRegistry() {
        handlers.put(OrderStatus.NEW, new NewOrderStatusHandler());
        handlers.put(OrderStatus.PAID, new PaidOrderStatusHandler());
        handlers.put(OrderStatus.SHIPPED, new ShippedOrderStatusHandler());
        handlers.put(OrderStatus.CANCELLED, new CancelledOrderStatusHandler());
    }

    public OrderStatusHandler getFor(OrderStatus status) {
        OrderStatusHandler handler = handlers.get(status);
        if (handler == null) {
            throw new IllegalArgumentException("Unsupported order status: " + status);
        }
        return handler;
    }
}
