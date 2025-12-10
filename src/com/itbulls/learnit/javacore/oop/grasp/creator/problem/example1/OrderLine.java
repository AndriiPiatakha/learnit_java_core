package com.itbulls.learnit.javacore.oop.grasp.creator.problem.example1;

public class OrderLine {

    private final String productId;
    private final String productName;
    private final int quantity;
    private final double unitPrice;

    public OrderLine(String productId, String productName, int quantity, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}