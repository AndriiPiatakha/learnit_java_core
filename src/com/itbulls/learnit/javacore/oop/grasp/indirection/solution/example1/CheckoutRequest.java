package com.itbulls.learnit.javacore.oop.grasp.indirection.solution.example1;

public class CheckoutRequest {

    private final String customerEmail;
    private final String productId;
    private final int quantity;
    private final double unitPrice;

    public CheckoutRequest(String customerEmail, String productId, int quantity, double unitPrice) {
        this.customerEmail = customerEmail;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getCustomerEmail() {
        return customerEmail;
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

    public double totalAmount() {
        return unitPrice * quantity;
    }
}
