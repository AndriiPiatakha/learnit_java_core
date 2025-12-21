package com.itbulls.learnit.javacore.oop.grasp.indirection.problem.example1;

public class InventoryService {

    public boolean reserve(String productId, int qty) {
        System.out.println("Inventory: reserve product=" + productId + " qty=" + qty);
        return true;
    }

    public void release(String productId, int qty) {
        System.out.println("Inventory: release product=" + productId + " qty=" + qty);
    }
}
