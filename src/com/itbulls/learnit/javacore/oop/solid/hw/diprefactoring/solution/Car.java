package com.itbulls.learnit.javacore.oop.solid.hw.diprefactoring.solution;

public class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();
    }
}