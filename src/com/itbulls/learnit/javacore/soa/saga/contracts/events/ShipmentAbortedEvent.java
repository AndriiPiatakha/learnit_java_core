package com.itbulls.learnit.javacore.soa.saga.contracts.events;

import java.time.Instant;
import java.util.UUID;

import com.itbulls.learnit.javacore.soa.saga.common.events.Event;

public record ShipmentAbortedEvent(
        UUID eventId,
        Instant occurredAt,
        String sagaId,
        String orderId,
        String reason
) implements Event {

    public static ShipmentAbortedEvent now(String sagaId, String orderId, String reason) {
        return new ShipmentAbortedEvent(UUID.randomUUID(), Instant.now(), sagaId, orderId, reason);
    }
}