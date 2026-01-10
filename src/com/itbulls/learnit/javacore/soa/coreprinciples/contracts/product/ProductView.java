package com.itbulls.learnit.javacore.soa.coreprinciples.contracts.product;

public record ProductView(
        String sku,
        String title,
        int availableStock
) { }
