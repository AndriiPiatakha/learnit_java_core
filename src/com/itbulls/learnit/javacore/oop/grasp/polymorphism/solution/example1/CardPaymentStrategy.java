package com.itbulls.learnit.javacore.oop.grasp.polymorphism.solution.example1;

public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(PaymentRequest request) {
        System.out.println("Charging CARD for customer " + request.getCustomerId()
                + " amount=" + request.getAmount());
    }
}
