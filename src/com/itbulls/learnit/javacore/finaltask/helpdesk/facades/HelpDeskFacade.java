package com.itbulls.learnit.javacore.finaltask.helpdesk.facades;

import com.itbulls.learnit.javacore.finaltask.helpdesk.enteties.SupportTicket;

public interface HelpDeskFacade {
	
	void addNewSupportTicket(SupportTicket supportTicket);
	
	SupportTicket getNextSupportTicket();

	/**
	 * @return amount of tickets that are not processed
	 */
	int getNumberOfTickets();
}
