package com.itbulls.learnit.javacore.soa.acl.legacy;

/**
 * Legacy DTO from an external / old system.
 * Notice: naming, types, and semantics are NOT what we want inside the new domain.
 */
public record LegacyCustomerDto(
        String cust_id,          // legacy naming
        String full_name,        // combined field
        String status_code,      // "A", "B", "S" ...
        int risk_score,          // 0..100
        String segment_code      // "VIP", "REG", "NEW" ...
) { }