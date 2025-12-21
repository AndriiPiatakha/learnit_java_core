package com.itbulls.learnit.javacore.oop.grasp.purefabrication.problem.example2;

//PROBLEM: "service everything" - domain is anemic, service is procedural.
//This service owns core business rules and manipulates entities directly.

public class TransferServiceGod {

	private final BankAccountRepository repository = new BankAccountRepository();
	private final AuditService auditService = new AuditService();

	public void transfer(String fromId, String toId, double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Amount must be positive");
		}

		BankAccount from = repository.findById(fromId);
		BankAccount to = repository.findById(toId);

		if (from.getBalance() < amount) {
			throw new IllegalStateException("Insufficient funds");
		}

		// service directly changes balances (domain has no behavior)
		from.setBalance(from.getBalance() - amount);
		to.setBalance(to.getBalance() + amount);

		repository.save(from);
		repository.save(to);

		auditService.log("Transferred " + amount + " from " + fromId + " to " + toId);
	}
}