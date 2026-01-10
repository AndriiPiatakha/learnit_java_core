package com.itbulls.learnit.javacore.soa.coreprinciples.contracts.customer;

import java.util.Optional;

public interface CustomerServiceContract {
    Optional<CustomerView> findCustomerById(String customerId);
}
