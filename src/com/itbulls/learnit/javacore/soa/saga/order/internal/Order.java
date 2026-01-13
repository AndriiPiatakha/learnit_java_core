package com.itbulls.learnit.javacore.soa.saga.order.internal;

public final class Order {

    public enum Status {
        NEW,
        CANCELLED,
        COMPLETED
    }

    private final String orderId;
    private final String customerId;
    private final double amount;
    private Status status = Status.NEW;

    public Order(String orderId, String customerId, double amount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
    }

    public String orderId() { return orderId; }
    public String customerId() { return customerId; }
    public double amount() { return amount; }
    public Status status() { return status; }

    public void cancel() { this.status = Status.CANCELLED; }
    public void complete() { this.status = Status.COMPLETED; }
}
