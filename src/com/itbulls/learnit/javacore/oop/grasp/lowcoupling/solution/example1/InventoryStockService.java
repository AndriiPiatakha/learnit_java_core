package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example1;

public class InventoryStockService implements StockService {

    private final InventoryService inventoryService;

    public InventoryStockService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Override
    public boolean reserve(String productId, int quantity) {
        return inventoryService.reserve(productId, quantity);
    }
}
