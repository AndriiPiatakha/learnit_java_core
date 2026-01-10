package com.itbulls.learnit.javacore.soa.coreprinciples.customer;


import java.util.Optional;

import com.itbulls.learnit.javacore.soa.coreprinciples.contracts.customer.CustomerServiceContract;
import com.itbulls.learnit.javacore.soa.coreprinciples.contracts.customer.CustomerView;
import com.itbulls.learnit.javacore.soa.coreprinciples.customer.internal.CustomerRepository;

public final class CustomerService implements CustomerServiceContract {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<CustomerView> findCustomerById(String customerId) {
        return repository.findById(customerId)
                .map(c -> new CustomerView(c.id(), c.fullName(), c.active()));
    }
}