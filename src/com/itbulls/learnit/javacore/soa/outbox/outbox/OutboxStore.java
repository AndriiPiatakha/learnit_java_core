package com.itbulls.learnit.javacore.soa.outbox.outbox;

import java.util.List;

public interface OutboxStore {
    OutboxRecord add(Object eventPayload);
    List<OutboxRecord> findPending(int limit);
    void markSent(long outboxId);
    void markFailed(long outboxId, String error);
}
