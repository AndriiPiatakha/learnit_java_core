package com.itbulls.learnit.javacore.soa.coreprinciples.contracts.events;

import java.time.Instant;
import java.util.UUID;

import com.itbulls.learnit.javacore.soa.coreprinciples.common.events.Event;

public record OrderPlacedEvent(
        UUID eventId,
        Instant occurredAt,
        String orderId,
        String customerId,
        String sku,
        int quantity
) implements Event {

    public static OrderPlacedEvent now(String orderId, String customerId, String sku, int quantity) {
        return new OrderPlacedEvent(UUID.randomUUID(), Instant.now(), orderId, customerId, sku, quantity);
    }
}