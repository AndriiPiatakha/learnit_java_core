package com.itbulls.learnit.javacore.soa.saga.contracts.events;

import java.time.Instant;
import java.util.UUID;

import com.itbulls.learnit.javacore.soa.saga.common.events.Event;

public record PaymentRefundedEvent(
        UUID eventId,
        Instant occurredAt,
        String sagaId,
        String orderId,
        String refundId
) implements Event {

    public static PaymentRefundedEvent now(String sagaId, String orderId, String refundId) {
        return new PaymentRefundedEvent(UUID.randomUUID(), Instant.now(), sagaId, orderId, refundId);
    }
}