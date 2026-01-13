package com.itbulls.learnit.javacore.soa.outbox.outbox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.itbulls.learnit.javacore.soa.outbox.common.events.Event;

public final class InMemoryOutboxStore implements OutboxStore {

    private final AtomicLong seq = new AtomicLong(100);
    private final ConcurrentHashMap<Long, OutboxRecord> records = new ConcurrentHashMap<>();

    @Override
    public OutboxRecord add(Object eventPayload) {
        if (!(eventPayload instanceof Event e)) {
            throw new IllegalArgumentException("Outbox supports only Event payloads");
        }
        long id = seq.incrementAndGet();
        OutboxRecord rec = new OutboxRecord(id, e);
        records.put(id, rec);
        return rec;
    }

    @Override
    public List<OutboxRecord> findPending(int limit) {
        List<OutboxRecord> list = new ArrayList<>();
        for (OutboxRecord r : records.values()) {
            if (r.status() == OutboxStatus.PENDING) {
                list.add(r);
            }
        }
        list.sort(Comparator.comparing(OutboxRecord::createdAt));
        if (list.size() <= limit) return list;
        return list.subList(0, limit);
    }

    @Override
    public void markSent(long outboxId) {
        OutboxRecord r = Objects.requireNonNull(records.get(outboxId), "unknown outboxId");
        r.markSent();
    }

    @Override
    public void markFailed(long outboxId, String error) {
        OutboxRecord r = Objects.requireNonNull(records.get(outboxId), "unknown outboxId");
        r.markAttemptFailed(error);
    }
}