package com.itbulls.learnit.javacore.oop.grasp.polymorphism.solution.example1;

public class PaymentRequest {

    private final PaymentMethodType methodType;
    private final String customerId;
    private final double amount;

    public PaymentRequest(PaymentMethodType methodType, String customerId, double amount) {
        this.methodType = methodType;
        this.customerId = customerId;
        this.amount = amount;
    }

    public PaymentMethodType getMethodType() {
        return methodType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }
}
