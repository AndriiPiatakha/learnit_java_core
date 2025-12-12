package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.problem.example2;

public class SalesRecord {

    private final String orderId;
    private final String productId;
    private final int quantity;
    private final double totalAmount;

    public SalesRecord(String orderId, String productId, int quantity, double totalAmount) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
