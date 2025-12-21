package com.itbulls.learnit.javacore.oop.grasp.purefabrication.solution.example2;

//Pure Fabrication is still used: repository + audit are technical concerns.
//But business rules (withdraw/deposit) stay inside BankAccount.

public class TransferService {

 private final BankAccountRepository repository;
 private final AuditService auditService;

 public TransferService(BankAccountRepository repository, AuditService auditService) {
     this.repository = repository;
     this.auditService = auditService;
 }

 public void transfer(String fromId, String toId, double amount) {
     BankAccount from = repository.findById(fromId);
     BankAccount to = repository.findById(toId);

     from.withdraw(amount);
     to.deposit(amount);

     repository.save(from);
     repository.save(to);

     auditService.log("Transferred " + amount + " from " + fromId + " to " + toId);
 }
}
