package com.itbulls.learnit.javacore.soa.outbox.contracts.evetns;

import java.time.Instant;
import java.util.UUID;

import com.itbulls.learnit.javacore.soa.outbox.common.events.Event;

public record OrderCreatedEvent(
        UUID eventId,
        Instant occurredAt,
        String orderId,
        String customerId,
        double amount
) implements Event {

    public static OrderCreatedEvent now(String orderId, String customerId, double amount) {
        return new OrderCreatedEvent(UUID.randomUUID(), Instant.now(), orderId, customerId, amount);
    }
}