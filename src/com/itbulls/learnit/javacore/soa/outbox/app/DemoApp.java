package com.itbulls.learnit.javacore.soa.outbox.app;

import com.itbulls.learnit.javacore.soa.outbox.common.events.InMemoryEventBus;
import com.itbulls.learnit.javacore.soa.outbox.contracts.evetns.OrderCreatedEvent;
import com.itbulls.learnit.javacore.soa.outbox.domain.InMemoryOrderStore;
import com.itbulls.learnit.javacore.soa.outbox.domain.OrderService;
import com.itbulls.learnit.javacore.soa.outbox.outbox.InMemoryOutboxStore;
import com.itbulls.learnit.javacore.soa.outbox.outbox.OutboxPublisher;

public final class DemoApp {

    public static void main(String[] args) {
        var broker = new InMemoryEventBus();

        // Consumer simulation
        broker.subscribe(OrderCreatedEvent.class, e ->
                System.out.println("[Consumer] received OrderCreated: orderId=" + e.orderId() +
                        " customerId=" + e.customerId() +
                        " amount=" + e.amount())
        );

        var orderStore = new InMemoryOrderStore();
        var outbox = new InMemoryOutboxStore();

        var orderService = new OrderService(orderStore, outbox);

        // Fail first 2 publishes to show retry behavior
        var publisher = new OutboxPublisher(outbox, broker, 2);

        System.out.println("=== Create Order (business tx writes order + outbox) ===");
        String orderId = orderService.createOrder("C-1", 100.0);
        System.out.println("Order created: " + orderId);

        System.out.println("\n=== Publisher run #1 (expected to fail) ===");
        publisher.publishBatch(10);

        System.out.println("\n=== Publisher run #2 (expected to fail) ===");
        publisher.publishBatch(10);

        System.out.println("\n=== Publisher run #3 (expected to succeed) ===");
        publisher.publishBatch(10);

        System.out.println("\n=== End ===");
    }
}