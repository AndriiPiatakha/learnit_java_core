package com.itbulls.learnit.javacore.oop.grasp.purefabrication.solution.example2;

public class BankAccountRepository {

    public BankAccount findById(String id) {
        System.out.println("DB: select account by id=" + id);
        return new BankAccount(id, 100.0);
    }

    public void save(BankAccount account) {
        System.out.println("DB: update account id=" + account.getId() +
                " balance=" + account.getBalance());
    }
}
