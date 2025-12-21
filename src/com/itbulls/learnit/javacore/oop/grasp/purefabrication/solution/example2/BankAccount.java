package com.itbulls.learnit.javacore.oop.grasp.purefabrication.solution.example2;

public class BankAccount {

    private final String id;
    private double balance;

    public BankAccount(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    // Domain rules live here, not in a god service
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (balance < amount) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance += amount;
    }
}
