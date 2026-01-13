package com.itbulls.learnit.javacore.soa.saga.common.events;

import java.time.Instant;
import java.util.UUID;

public interface Event {
    UUID eventId();
    Instant occurredAt();
}