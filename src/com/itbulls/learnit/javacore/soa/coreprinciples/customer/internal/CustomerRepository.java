package com.itbulls.learnit.javacore.soa.coreprinciples.customer.internal;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public final class CustomerRepository {

    private final Map<String, Customer> customers = new ConcurrentHashMap<>();

    public void save(Customer customer) {
        customers.put(customer.id(), customer);
    }

    public Optional<Customer> findById(String id) {
        return Optional.ofNullable(customers.get(id));
    }
}
