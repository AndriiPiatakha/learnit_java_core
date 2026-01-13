package com.itbulls.learnit.javacore.soa.saga.common.idempotency;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class InMemoryProcessedEventStore implements ProcessedEventStore {

    private final Set<UUID> seen = ConcurrentHashMap.newKeySet();

    @Override
    public boolean markIfFirstTime(UUID eventId) {
        return seen.add(eventId);
    }
}
