package com.itbulls.learnit.javacore.soa.saga.contracts.events;

import java.time.Instant;
import java.util.UUID;

import com.itbulls.learnit.javacore.soa.saga.common.events.Event;

public record PaymentProcessedEvent(
        UUID eventId,
        Instant occurredAt,
        String sagaId,
        String orderId,
        String paymentId
) implements Event {

    public static PaymentProcessedEvent now(String sagaId, String orderId, String paymentId) {
        return new PaymentProcessedEvent(UUID.randomUUID(), Instant.now(), sagaId, orderId, paymentId);
    }
}