package com.itbulls.learnit.javacore.soa.saga.order;


import java.util.UUID;

import com.itbulls.learnit.javacore.soa.saga.common.events.EventBus;
import com.itbulls.learnit.javacore.soa.saga.contracts.events.OrderCancelledEvent;
import com.itbulls.learnit.javacore.soa.saga.contracts.events.OrderCreatedEvent;
import com.itbulls.learnit.javacore.soa.saga.order.internal.Order;
import com.itbulls.learnit.javacore.soa.saga.order.internal.OrderRepository;

public final class OrderService {

    private final OrderRepository repo;
    private final EventBus bus;

    public OrderService(OrderRepository repo, EventBus bus) {
        this.repo = repo;
        this.bus = bus;
    }

    public String createOrder(String customerId, double amount) {
        String orderId = "O-" + UUID.randomUUID();
        String sagaId = "S-" + UUID.randomUUID();

        repo.save(new Order(orderId, customerId, amount));
        bus.publish(OrderCreatedEvent.now(sagaId, orderId, customerId, amount));

        return sagaId;
    }

    public void cancelOrder(String sagaId, String orderId, String reason) {
        repo.findById(orderId).ifPresent(Order::cancel);
        bus.publish(OrderCancelledEvent.now(sagaId, orderId, reason));
    }

    public void completeOrder(String orderId) {
        repo.findById(orderId).ifPresent(Order::complete);
    }
}
