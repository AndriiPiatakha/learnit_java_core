package com.itbulls.learnit.javacore.oop.grasp.protectedvariations.problem.example2;

//Simulates an unstable external API.
public class LegacyCrmApi {

 public LegacyCrmContactRecord fetchContactByCustomerId(String customerId) {
     System.out.println("LegacyCRM: fetchContactByCustomerId customerId=" + customerId);
     return new LegacyCrmContactRecord("LEG-" + customerId, "legacy_" + customerId + "@mail.com", "SEG_A");
 }
}