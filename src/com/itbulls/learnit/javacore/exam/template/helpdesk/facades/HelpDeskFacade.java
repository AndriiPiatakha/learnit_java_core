package com.itbulls.learnit.javacore.exam.template.helpdesk.facades;

import com.itbulls.learnit.javacore.exam.template.helpdesk.enteties.SupportTicket;

public interface HelpDeskFacade {
	
	void addNewSupportTicket(SupportTicket supportTicket);
	
	SupportTicket getNextSupportTicket();

	/**
	 * @return amount of tickets that are not processed
	 */
	int getNumberOfTickets();
}
