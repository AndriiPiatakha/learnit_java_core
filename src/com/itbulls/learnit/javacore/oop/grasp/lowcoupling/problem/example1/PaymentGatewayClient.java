package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.problem.example1;

public class PaymentGatewayClient {

    public boolean charge(String customerId, double amount) {
        System.out.println("Charging customer " + customerId + " amount=" + amount);
        return true;
    }
}