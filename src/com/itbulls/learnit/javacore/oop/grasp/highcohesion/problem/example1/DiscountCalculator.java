package com.itbulls.learnit.javacore.oop.grasp.highcohesion.problem.example1;

public class DiscountCalculator {

    public double calculateDiscountForCustomer(String customerId, double total) {
        if (total > 200) {
            return total * 0.15;
        }
        if (total > 100) {
            return total * 0.10;
        }
        return 0.0;
    }
}
