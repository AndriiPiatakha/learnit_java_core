package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example1;

public class PaymentGatewayPaymentService implements PaymentService {

    private final PaymentGatewayClient client;

    public PaymentGatewayPaymentService(PaymentGatewayClient client) {
        this.client = client;
    }

    @Override
    public boolean charge(String customerId, double amount) {
        return client.charge(customerId, amount);
    }
}