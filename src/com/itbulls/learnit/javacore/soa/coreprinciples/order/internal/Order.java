package com.itbulls.learnit.javacore.soa.coreprinciples.order.internal;

public final class Order {

    public enum Status {
        NEW,
        PLACED,
        REJECTED
    }

    private final String orderId;
    private final String customerId;
    private final String sku;
    private final int quantity;
    private Status status;

    public Order(String orderId, String customerId, String sku, int quantity) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.sku = sku;
        this.quantity = quantity;
        this.status = Status.NEW;
    }

    public String orderId() { return orderId; }
    public String customerId() { return customerId; }
    public String sku() { return sku; }
    public int quantity() { return quantity; }
    public Status status() { return status; }

    public void placed() { this.status = Status.PLACED; }
    public void rejected() { this.status = Status.REJECTED; }
}