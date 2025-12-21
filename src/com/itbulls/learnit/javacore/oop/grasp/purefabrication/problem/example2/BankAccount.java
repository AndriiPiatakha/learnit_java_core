package com.itbulls.learnit.javacore.oop.grasp.purefabrication.problem.example2;

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

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
