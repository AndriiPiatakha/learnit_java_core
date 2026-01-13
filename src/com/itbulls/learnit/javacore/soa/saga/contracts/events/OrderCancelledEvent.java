package com.itbulls.learnit.javacore.soa.saga.contracts.events;

import java.time.Instant;
import java.util.UUID;

import com.itbulls.learnit.javacore.soa.saga.common.events.Event;

public record OrderCancelledEvent(
        UUID eventId,
        Instant occurredAt,
        String sagaId,
        String orderId,
        String reason
) implements Event {

    public static OrderCancelledEvent now(String sagaId, String orderId, String reason) {
        return new OrderCancelledEvent(UUID.randomUUID(), Instant.now(), sagaId, orderId, reason);
    }
}
