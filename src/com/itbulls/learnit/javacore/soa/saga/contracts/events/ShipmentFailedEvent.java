package com.itbulls.learnit.javacore.soa.saga.contracts.events;

import java.time.Instant;
import java.util.UUID;

import com.itbulls.learnit.javacore.soa.saga.common.events.Event;

public record ShipmentFailedEvent(
        UUID eventId,
        Instant occurredAt,
        String sagaId,
        String orderId,
        String reason
) implements Event {

    public static ShipmentFailedEvent now(String sagaId, String orderId, String reason) {
        return new ShipmentFailedEvent(UUID.randomUUID(), Instant.now(), sagaId, orderId, reason);
    }
}
