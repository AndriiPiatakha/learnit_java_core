package com.itbulls.learnit.javacore.soa.acl.newservice.domain;

/**
 * Clean domain model used only inside the new service.
 * No legacy naming, no legacy codes.
 */
public record CustomerProfile(
        String customerId,
        String name,
        boolean active,
        RiskTier riskTier,
        String segment
) { }