package com.itbulls.learnit.javacore.oop.grasp.highcohesion.solution.example1;

public class OrderLine {

    private final String productName;
    private final int quantity;
    private final double unitPrice;

    public OrderLine(String productName, int quantity, double unitPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
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