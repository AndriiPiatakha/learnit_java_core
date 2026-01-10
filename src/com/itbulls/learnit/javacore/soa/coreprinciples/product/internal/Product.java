package com.itbulls.learnit.javacore.soa.coreprinciples.product.internal;

public final class Product {
    private final String sku;
    private final String title;
    private int availableStock;

    public Product(String sku, String title, int availableStock) {
        this.sku = sku;
        this.title = title;
        this.availableStock = availableStock;
    }

    public String sku() { return sku; }
    public String title() { return title; }
    public int availableStock() { return availableStock; }

    public void reserve(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be > 0");
        }
        if (availableStock < quantity) {
            throw new IllegalStateException("not enough stock for sku=" + sku);
        }
        availableStock -= quantity;
    }
}
