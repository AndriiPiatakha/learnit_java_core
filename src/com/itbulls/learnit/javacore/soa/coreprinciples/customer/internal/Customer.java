package com.itbulls.learnit.javacore.soa.coreprinciples.customer.internal;

public final class Customer {
    private final String id;
    private final String fullName;
    private boolean active;

    public Customer(String id, String fullName, boolean active) {
        this.id = id;
        this.fullName = fullName;
        this.active = active;
    }

    public String id() { return id; }
    public String fullName() { return fullName; }
    public boolean active() { return active; }

    public void deactivate() {
        this.active = false;
    }
}