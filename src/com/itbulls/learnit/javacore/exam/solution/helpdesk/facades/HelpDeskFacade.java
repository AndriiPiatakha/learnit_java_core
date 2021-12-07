package com.itbulls.learnit.javacore.exam.solution.helpdesk.facades;

import com.itbulls.learnit.javacore.exam.solution.helpdesk.enteties.SupportTicket;

public interface HelpDeskFacade {
	
	void addNewSupportTicket(SupportTicket supportTicket);
	
	SupportTicket getNextSupportTicket();

	/**
	 * @return amount of tickets that are not processed
	 */
	int getNumberOfTickets();
}
