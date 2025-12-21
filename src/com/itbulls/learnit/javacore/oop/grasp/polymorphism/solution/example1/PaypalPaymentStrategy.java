package com.itbulls.learnit.javacore.oop.grasp.polymorphism.solution.example1;

public class PaypalPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(PaymentRequest request) {
        System.out.println("Charging PAYPAL for customer " + request.getCustomerId()
                + " amount=" + request.getAmount());
    }
}
