package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example1;

public class Product {

    private final String id;
    private final String name;
    private final double unitPrice;

    public Product(String id, String name, double unitPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
