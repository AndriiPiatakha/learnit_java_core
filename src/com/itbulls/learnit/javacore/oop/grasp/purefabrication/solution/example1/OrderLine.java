package com.itbulls.learnit.javacore.oop.grasp.purefabrication.solution.example1;

public class OrderLine {

    private final String productId;
    private final int quantity;
    private final double unitPrice;

    public OrderLine(String productId, int quantity, double unitPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
