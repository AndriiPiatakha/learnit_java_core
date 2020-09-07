package com.itbulls.learnit.javacore.oop.solid.o.problem;

public class LoanHandler {
	
	private PersonalLoanValidator personalLoanValidator;
	private MortgageLoanValidator mortgageValidator;
	
	public void approvePersonalLoan(User user) {
		if (personalLoanValidator.isValidUserForPersonalLoan(user)) {
			// proceed with personal loan approval
		}
	}
	
	public void approveMortgage(User user) {
		if (mortgageValidator.isValidUserForMortgage(user)) {
			// proceed with personal loan approval
		}
	}

}
