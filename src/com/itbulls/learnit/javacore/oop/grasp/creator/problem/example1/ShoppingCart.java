package com.itbulls.learnit.javacore.oop.grasp.creator.problem.example1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {

    private final String customerId;
    private final List<CartItem> items = new ArrayList<>();

    public ShoppingCart(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }
}