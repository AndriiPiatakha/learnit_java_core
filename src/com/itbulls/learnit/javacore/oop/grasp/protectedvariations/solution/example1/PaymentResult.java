package com.itbulls.learnit.javacore.oop.grasp.protectedvariations.solution.example1;

public class PaymentResult {

    private final boolean success;
    private final String reference;

    public PaymentResult(boolean success, String reference) {
        this.success = success;
        this.reference = reference;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getReference() {
        return reference;
    }
}