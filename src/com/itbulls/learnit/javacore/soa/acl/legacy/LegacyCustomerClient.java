package com.itbulls.learnit.javacore.soa.acl.legacy;

import java.util.Map;
import java.util.Optional;

/**
 * Simulates a legacy service API client.
 * In real life it could be REST/SOAP/DB/CDC - doesn't matter for the ACL concept.
 */
public final class LegacyCustomerClient {

    private final Map<String, LegacyCustomerDto> data =
            Map.of(
                    "C-1", new LegacyCustomerDto("C-1", "Alice Johnson", "A", 12, "VIP"),
                    "C-2", new LegacyCustomerDto("C-2", "Bob Smith", "S", 78, "REG"),
                    "C-3", new LegacyCustomerDto("C-3", "Eve Adams", "B", 55, "NEW")
            );

    public Optional<LegacyCustomerDto> fetchCustomer(String customerId) {
        return Optional.ofNullable(data.get(customerId));
    }
}
