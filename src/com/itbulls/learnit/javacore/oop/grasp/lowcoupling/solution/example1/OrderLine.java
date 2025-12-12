package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example1;

public class OrderLine {

    private final Product product;
    private final int quantity;

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
}
