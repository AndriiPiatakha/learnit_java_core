package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example1;

public interface DiscountPolicy {

    double calculateDiscount(String customerId, double total);
}