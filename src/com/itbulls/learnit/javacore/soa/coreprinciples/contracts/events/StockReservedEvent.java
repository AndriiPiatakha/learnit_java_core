package com.itbulls.learnit.javacore.soa.coreprinciples.contracts.events;


import java.time.Instant;
import java.util.UUID;

import com.itbulls.learnit.javacore.soa.coreprinciples.common.events.Event;

public record StockReservedEvent(
        UUID eventId,
        Instant occurredAt,
        String orderId,
        String sku,
        int quantity
) implements Event {

    public static StockReservedEvent now(String orderId, String sku, int quantity) {
        return new StockReservedEvent(UUID.randomUUID(), Instant.now(), orderId, sku, quantity);
    }
}
