package com.itbulls.learnit.javacore.oop.grasp.polymorphism.solution.example1;

public class PaymentProcessorPolymorphic {

    private final PaymentStrategyRegistry registry;

    public PaymentProcessorPolymorphic(PaymentStrategyRegistry registry) {
        this.registry = registry;
    }

    public void pay(PaymentRequest request) {
        PaymentStrategy strategy = registry.getFor(request.getMethodType());
        strategy.pay(request);
    }
}