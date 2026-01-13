package com.itbulls.learnit.javacore.soa.saga.contracts.events;

import java.time.Instant;
import java.util.UUID;

import com.itbulls.learnit.javacore.soa.saga.common.events.Event;

public record ShipmentArrangedEvent(
        UUID eventId,
        Instant occurredAt,
        String sagaId,
        String orderId,
        String shipmentId
) implements Event {

    public static ShipmentArrangedEvent now(String sagaId, String orderId, String shipmentId) {
        return new ShipmentArrangedEvent(UUID.randomUUID(), Instant.now(), sagaId, orderId, shipmentId);
    }
}
