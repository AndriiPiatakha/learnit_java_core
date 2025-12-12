package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example1;

public interface PaymentService {

    boolean charge(String customerId, double amount);
}
