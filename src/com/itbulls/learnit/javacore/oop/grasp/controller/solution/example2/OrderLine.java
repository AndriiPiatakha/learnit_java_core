package com.itbulls.learnit.javacore.oop.grasp.controller.solution.example2;

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

    public double lineTotal() {
        return unitPrice * quantity;
    }
}
