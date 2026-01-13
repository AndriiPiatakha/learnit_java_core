package com.itbulls.learnit.javacore.soa.saga.contracts.events;

import java.time.Instant;
import java.util.UUID;

import com.itbulls.learnit.javacore.soa.saga.common.events.Event;

public record OrderCreatedEvent(
        UUID eventId,
        Instant occurredAt,
        String sagaId,
        String orderId,
        String customerId,
        double amount
) implements Event {

    public static OrderCreatedEvent now(String sagaId, String orderId, String customerId, double amount) {
        return new OrderCreatedEvent(UUID.randomUUID(), Instant.now(), sagaId, orderId, customerId, amount);
    }
}
