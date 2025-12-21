package com.itbulls.learnit.javacore.oop.grasp.polymorphism.solution.example1;

import java.util.EnumMap;
import java.util.Map;

public class PaymentStrategyRegistry {

    private final Map<PaymentMethodType, PaymentStrategy> strategies =
            new EnumMap<>(PaymentMethodType.class);

    public PaymentStrategyRegistry() {
        strategies.put(PaymentMethodType.CARD, new CardPaymentStrategy());
        strategies.put(PaymentMethodType.PAYPAL, new PaypalPaymentStrategy());
        strategies.put(PaymentMethodType.BANK_TRANSFER, new BankTransferPaymentStrategy());
    }

    public PaymentStrategy getFor(PaymentMethodType type) {
        PaymentStrategy strategy = strategies.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported payment method: " + type);
        }
        return strategy;
    }
}