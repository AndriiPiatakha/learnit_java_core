package com.itbulls.learnit.javacore.soa.outbox.domain;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class InMemoryOrderStore implements OrderStore {

    private final Map<String, Order> store = new ConcurrentHashMap<>();

    @Override
    public void save(Order order) {
        store.put(order.orderId(), order);
    }

    @Override
    public Optional<Order> findById(String orderId) {
        return Optional.ofNullable(store.get(orderId));
    }
}