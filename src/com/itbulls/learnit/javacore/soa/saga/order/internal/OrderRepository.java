package com.itbulls.learnit.javacore.soa.saga.order.internal;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class OrderRepository {

    private final Map<String, Order> store = new ConcurrentHashMap<>();

    public void save(Order order) {
        store.put(order.orderId(), order);
    }

    public Optional<Order> findById(String orderId) {
        return Optional.ofNullable(store.get(orderId));
    }
}
