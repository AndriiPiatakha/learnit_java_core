package com.itbulls.learnit.javacore.soa.outbox.domain;

public record Order(
        String orderId,
        String customerId,
        double amount
) { }
