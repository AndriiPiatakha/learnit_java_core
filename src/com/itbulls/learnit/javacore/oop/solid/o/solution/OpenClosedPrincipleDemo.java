package com.itbulls.learnit.javacore.oop.solid.o.solution;

public class OpenClosedPrincipleDemo {
	
	public static void main(String[] args) {
		LoanHandler loanHandler = new PersonalLoanHandler(new PersonalLoanValidator());
		User user = new User();
		
		loanHandler.approveLoan(user);
		
		LoanHandler loanHandler2 = new MortgageLoanHandler(new MortgageLoanValidator());
		loanHandler2.approveLoan(user);
	}

}
