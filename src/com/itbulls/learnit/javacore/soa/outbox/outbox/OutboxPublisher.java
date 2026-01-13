package com.itbulls.learnit.javacore.soa.outbox.outbox;

import java.util.Objects;

import com.itbulls.learnit.javacore.soa.outbox.common.events.EventBus;

public final class OutboxPublisher {

    private final OutboxStore outbox;
    private final EventBus broker;

    // Demo switch: fail first N publish attempts globally
    private int failNextPublishes;

    public OutboxPublisher(OutboxStore outbox, EventBus broker, int failNextPublishes) {
        this.outbox = Objects.requireNonNull(outbox);
        this.broker = Objects.requireNonNull(broker);
        this.failNextPublishes = Math.max(0, failNextPublishes);
    }

    public void publishBatch(int limit) {
        for (OutboxRecord rec : outbox.findPending(limit)) {
            try {
                publishOne(rec);
                outbox.markSent(rec.id());
                System.out.println("[Publisher] SENT outboxId=" + rec.id() +
                        " eventType=" + simple(rec.eventType()) +
                        " attempts=" + (rec.attempts() + 1));
            } catch (Exception ex) {
                outbox.markFailed(rec.id(), ex.getMessage());
                System.out.println("[Publisher] FAILED outboxId=" + rec.id() +
                        " error=" + ex.getMessage() +
                        " attempts=" + rec.attempts());
            }
        }
    }

    private void publishOne(OutboxRecord rec) {
        if (failNextPublishes > 0) {
            failNextPublishes--;
            throw new RuntimeException("broker unavailable (simulated)");
        }
        broker.publish(rec.eventPayload());
    }

    private static String simple(String fqcn) {
        int idx = fqcn.lastIndexOf('.');
        return idx >= 0 ? fqcn.substring(idx + 1) : fqcn;
    }
}
