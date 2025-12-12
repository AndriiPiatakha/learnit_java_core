package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example1;

public class DefaultDiscountPolicy implements DiscountPolicy {

    private final DiscountService discountService;

    public DefaultDiscountPolicy(DiscountService discountService) {
        this.discountService = discountService;
    }

    @Override
    public double calculateDiscount(String customerId, double total) {
        return discountService.calculateDiscount(customerId, total);
    }
}