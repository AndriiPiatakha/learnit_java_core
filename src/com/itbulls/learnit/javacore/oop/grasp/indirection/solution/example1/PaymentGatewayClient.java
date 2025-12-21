package com.itbulls.learnit.javacore.oop.grasp.indirection.solution.example1;

public class PaymentGatewayClient {

    public boolean charge(double amount) {
        System.out.println("PaymentGateway: charge " + amount);
        return true;
    }
}
