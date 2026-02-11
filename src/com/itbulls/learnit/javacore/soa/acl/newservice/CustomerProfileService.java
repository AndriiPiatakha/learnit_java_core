package com.itbulls.learnit.javacore.soa.acl.newservice;

import java.util.Objects;

import com.itbulls.learnit.javacore.soa.acl.newservice.acl.CustomerProfileAcl;
import com.itbulls.learnit.javacore.soa.acl.newservice.domain.CustomerProfile;

public final class CustomerProfileService {

    private final CustomerProfileAcl acl;

    public CustomerProfileService(CustomerProfileAcl acl) {
        this.acl = Objects.requireNonNull(acl);
    }

    public CustomerProfile getCustomerProfileOrThrow(String customerId) {
        return acl.findProfile(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found: " + customerId));
    }
}