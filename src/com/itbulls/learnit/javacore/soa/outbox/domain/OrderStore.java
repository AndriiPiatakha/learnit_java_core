package com.itbulls.learnit.javacore.soa.outbox.domain;

import java.util.Optional;

public interface OrderStore {
    void save(Order order);
    Optional<Order> findById(String orderId);
}