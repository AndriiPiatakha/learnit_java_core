package com.itbulls.learnit.javacore.oop.grasp.infoexpert.solution.example1;

public class OrderLine {

    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    // Information Expert: OrderLine knows product and quantity
    public double calculateLineTotal() {
        double base = product.getPrice() * quantity;
        return base * (1 - discountRate());
    }

    private double discountRate() {
        if (quantity > 10) {
            return 0.10;
        }
        return 0.0;
    }
}
