package com.itbulls.learnit.javacore.soa.saga.contracts.events;

import java.time.Instant;
import java.util.UUID;

import com.itbulls.learnit.javacore.soa.saga.common.events.Event;

public record PaymentFailedEvent(
        UUID eventId,
        Instant occurredAt,
        String sagaId,
        String orderId,
        String reason
) implements Event {

    public static PaymentFailedEvent now(String sagaId, String orderId, String reason) {
        return new PaymentFailedEvent(UUID.randomUUID(), Instant.now(), sagaId, orderId, reason);
    }
}