package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example1;

public class DiscountService {

    public double calculateDiscount(String customerId, double total) {
        if (total > 100) {
            return total * 0.1; // 10 percent discount
        }
        return 0.0;
    }
}
