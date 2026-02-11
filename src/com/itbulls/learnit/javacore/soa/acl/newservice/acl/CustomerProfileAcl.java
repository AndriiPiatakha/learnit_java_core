package com.itbulls.learnit.javacore.soa.acl.newservice.acl;

import java.util.Objects;
import java.util.Optional;

import com.itbulls.learnit.javacore.soa.acl.legacy.LegacyCustomerClient;
import com.itbulls.learnit.javacore.soa.acl.newservice.domain.CustomerProfile;

/**
 * Anti Corruption Layer: the boundary that protects the new service.
 * The new service depends on THIS, not on legacy DTOs or legacy clients directly.
 */
public final class CustomerProfileAcl {

    private final LegacyCustomerClient legacyClient;
    private final LegacyToDomainMapper mapper;

    public CustomerProfileAcl(LegacyCustomerClient legacyClient, LegacyToDomainMapper mapper) {
        this.legacyClient = Objects.requireNonNull(legacyClient);
        this.mapper = Objects.requireNonNull(mapper);
    }

    public Optional<CustomerProfile> findProfile(String customerId) {
        return legacyClient.fetchCustomer(customerId).map(mapper::toCustomerProfile);
    }
}
