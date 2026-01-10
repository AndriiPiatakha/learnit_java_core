package com.itbulls.learnit.javacore.soa.coreprinciples.contracts.customer;

public record CustomerView(
        String customerId,
        String fullName,
        boolean active
) { }