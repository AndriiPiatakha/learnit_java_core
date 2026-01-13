package com.itbulls.learnit.javacore.soa.saga.saga;

public final class SagaState {

    public enum Status {
        STARTED,
        PAYMENT_OK,
        SHIPPING_OK,
        COMPLETED,
        COMPENSATING,
        CANCELLED
    }

    private final String sagaId;
    private final String orderId;
    private Status status;

    public SagaState(String sagaId, String orderId) {
        this.sagaId = sagaId;
        this.orderId = orderId;
        this.status = Status.STARTED;
    }

    public String sagaId() { return sagaId; }
    public String orderId() { return orderId; }
    public Status status() { return status; }

    public void status(Status status) { this.status = status; }
}