package com.itbulls.learnit.javacore.soa.outbox.outbox;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import com.itbulls.learnit.javacore.soa.outbox.common.events.Event;

public final class OutboxRecord {

    private final long id;
    private final UUID eventId;
    private final String eventType;
    private final Event eventPayload;
    private final Instant createdAt;

    private OutboxStatus status;
    private int attempts;
    private String lastError;

    public OutboxRecord(long id, Event eventPayload) {
        this.id = id;
        this.eventPayload = Objects.requireNonNull(eventPayload);
        this.eventId = eventPayload.eventId();
        this.eventType = eventPayload.getClass().getName();
        this.createdAt = Instant.now();
        this.status = OutboxStatus.PENDING;
        this.attempts = 0;
        this.lastError = null;
    }

    public long id() { return id; }
    public UUID eventId() { return eventId; }
    public String eventType() { return eventType; }
    public Event eventPayload() { return eventPayload; }
    public Instant createdAt() { return createdAt; }

    public OutboxStatus status() { return status; }
    public int attempts() { return attempts; }
    public String lastError() { return lastError; }

    public void markAttemptFailed(String error) {
        this.attempts++;
        this.lastError = error;
    }

    public void markSent() {
        this.status = OutboxStatus.SENT;
        this.lastError = null;
    }
}