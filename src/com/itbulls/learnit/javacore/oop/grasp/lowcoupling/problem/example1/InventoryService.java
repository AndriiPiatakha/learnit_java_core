package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.problem.example1;

public class InventoryService {

    public boolean reserve(String productId, int quantity) {
        System.out.println("Reserving " + quantity + " of product " + productId);
        return true;
    }
}