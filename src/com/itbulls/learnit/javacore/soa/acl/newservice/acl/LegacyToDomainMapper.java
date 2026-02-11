package com.itbulls.learnit.javacore.soa.acl.newservice.acl;

import com.itbulls.learnit.javacore.soa.acl.legacy.LegacyCustomerDto;
import com.itbulls.learnit.javacore.soa.acl.newservice.domain.CustomerProfile;
import com.itbulls.learnit.javacore.soa.acl.newservice.domain.RiskTier;

/**
 * Pure translation logic: legacy language -> new domain language.
 * This is NOT a dumb field-to-field mapper. It converts meaning.
 */
public final class LegacyToDomainMapper {

    public CustomerProfile toCustomerProfile(LegacyCustomerDto legacy) {
        boolean active = mapStatusToActive(legacy.status_code());
        RiskTier tier = mapRiskScoreToTier(legacy.risk_score());
        String segment = mapSegment(legacy.segment_code());

        return new CustomerProfile(
                legacy.cust_id(),
                legacy.full_name(),
                active,
                tier,
                segment
        );
    }

    private boolean mapStatusToActive(String statusCode) {
        // Legacy "A" = active, "S" = suspended, "B" = blocked
        return "A".equalsIgnoreCase(statusCode);
    }

    private RiskTier mapRiskScoreToTier(int score) {
        if (score <= 30) return RiskTier.LOW;
        if (score <= 70) return RiskTier.MEDIUM;
        return RiskTier.HIGH;
    }

    private String mapSegment(String segmentCode) {
        // Keep business-friendly names in the new service
        return switch (segmentCode) {
            case "VIP" -> "VIP";
            case "REG" -> "Regular";
            case "NEW" -> "New";
            default -> "Unknown";
        };
    }
}
