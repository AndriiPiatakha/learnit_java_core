package com.itbulls.learnit.javacore.oop.solid.hw.diprefactoring.task;

/*

In this file you can find violation of Dependency Inversion Principle. 
You should refactor this file. 
You can remove this file completely, because it will not be used during the evaluation of the solution.

Understanding Dependency Inversion Principle (DIP):

Learn about DIP, where high-level modules should not depend on low-level modules directly. Both should depend on abstractions.

Understand the benefits of DIP like flexibility, maintainability, and easier testing.

Identifying Code Violating DIP:

Examine provided Java code where Car class directly depends on Engine class.

Think about why this violates DIP and the need for refactoring.

Refactoring Code with DIP:

Follow the refactored solution: create Engine interface and implementing classes (ElectricEngine, GasolineEngine).

Understand how Car class now depends on Engine interface, aligning with DIP.

NOTE: solution will be verified by unit tests. Taking into account start() method is void, unit tests rely on console output. So, follow requirements for console output in appropriate methods: 

Electric engine started.

Gasoline engine started.

The source code of my solution is located here - https://github.com/AndriiPiatakha/learnit_java_core/tree/master/src/com/itbulls/learnit/javacore/oop/solid/hw/diprefactoring

*/

public class Car {
    private Engine engine;

    public Car() {
        this.engine = new Engine();
    }

    public void start() {
        engine.start();
    }
}

class Engine {
    public void start() {
        System.out.println("Engine started.");
    }
}
