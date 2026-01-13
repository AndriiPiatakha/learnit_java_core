package com.itbulls.learnit.javacore.soa.outbox.domain;


import java.util.Objects;
import java.util.UUID;

import com.itbulls.learnit.javacore.soa.outbox.contracts.evetns.OrderCreatedEvent;
import com.itbulls.learnit.javacore.soa.outbox.outbox.OutboxStore;

public final class OrderService {

    private final OrderStore orders;
    private final OutboxStore outbox;

    public OrderService(OrderStore orders, OutboxStore outbox) {
        this.orders = Objects.requireNonNull(orders);
        this.outbox = Objects.requireNonNull(outbox);
    }

    // This method simulates "one DB transaction":
    // 1) save business data
    // 2) write outbox record
    public String createOrder(String customerId, double amount) {
        String orderId = "O-" + UUID.randomUUID();

        orders.save(new Order(orderId, customerId, amount));

        // Instead of publishing to broker here, we write to Outbox
        outbox.add(OrderCreatedEvent.now(orderId, customerId, amount));

        return orderId;
    }
}