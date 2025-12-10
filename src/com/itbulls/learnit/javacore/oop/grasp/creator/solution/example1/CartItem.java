package com.itbulls.learnit.javacore.oop.grasp.creator.solution.example1;

public class CartItem {

    private final Product product;
    private final int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    // CartItem is the expert on how to turn itself into an OrderLine.
    public OrderLine toOrderLine() {
        return new OrderLine(
                product.getId(),
                product.getName(),
                quantity,
                product.getUnitPrice()
        );
    }
}
