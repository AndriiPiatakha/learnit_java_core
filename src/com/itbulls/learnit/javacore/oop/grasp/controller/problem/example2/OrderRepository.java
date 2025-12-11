package com.itbulls.learnit.javacore.oop.grasp.controller.problem.example2;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private final List<Order> storage = new ArrayList<>();

    public void save(Order order) {
        storage.add(order);
        System.out.println("Order saved for customer " + order.getCustomerId() +
                ", total = " + order.getTotalAmount());
    }
}
