package com.itbulls.learnit.javacore.oop.grasp.creator.solution.example2;

public class PaymentGatewayClient {

    private final String endpoint;

    public PaymentGatewayClient(String endpoint) {
        this.endpoint = endpoint;
    }

    public void charge(String customerId, double amount) {
        // Imagine external HTTP call here.
        System.out.println("Charging customer " + customerId + " amount " + amount +
                " via endpoint " + endpoint);
    }
}