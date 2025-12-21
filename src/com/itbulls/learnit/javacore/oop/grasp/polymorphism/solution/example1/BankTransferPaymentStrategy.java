package com.itbulls.learnit.javacore.oop.grasp.polymorphism.solution.example1;

public class BankTransferPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(PaymentRequest request) {
        System.out.println("Charging BANK TRANSFER for customer " + request.getCustomerId()
                + " amount=" + request.getAmount());
    }
}
