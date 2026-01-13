package com.itbulls.learnit.javacore.soa.saga.common.idempotency;

import java.util.UUID;

public interface ProcessedEventStore {
    boolean markIfFirstTime(UUID eventId);
}