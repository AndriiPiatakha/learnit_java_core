package com.itbulls.learnit.javacore.oop.grasp.highcohesion.problem.example1;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private final List<Order> storage = new ArrayList<>();

    public void save(Order order) {
        storage.add(order);
        System.out.println("Order saved: " + order.getId());
    }

    public List<Order> findAll() {
        return new ArrayList<>(storage);
    }
}
