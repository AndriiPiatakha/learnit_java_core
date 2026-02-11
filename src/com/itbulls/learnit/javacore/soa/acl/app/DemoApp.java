package com.itbulls.learnit.javacore.soa.acl.app;

import com.itbulls.learnit.javacore.soa.acl.legacy.LegacyCustomerClient;
import com.itbulls.learnit.javacore.soa.acl.newservice.CustomerProfileService;
import com.itbulls.learnit.javacore.soa.acl.newservice.acl.CustomerProfileAcl;
import com.itbulls.learnit.javacore.soa.acl.newservice.acl.LegacyToDomainMapper;

public final class DemoApp {

    public static void main(String[] args) {
        var legacyClient = new LegacyCustomerClient();

        var mapper = new LegacyToDomainMapper();
        var acl = new CustomerProfileAcl(legacyClient, mapper);

        var service = new CustomerProfileService(acl);

        System.out.println("=== ACL Demo ===");
        System.out.println(service.getCustomerProfileOrThrow("C-1"));
        System.out.println(service.getCustomerProfileOrThrow("C-2"));
        System.out.println(service.getCustomerProfileOrThrow("C-3"));
        System.out.println("=== End ===");
    }
}