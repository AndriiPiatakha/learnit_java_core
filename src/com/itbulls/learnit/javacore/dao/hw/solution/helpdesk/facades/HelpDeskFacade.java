package com.itbulls.learnit.javacore.dao.hw.solution.helpdesk.facades;

import com.itbulls.learnit.javacore.dao.hw.solution.helpdesk.enteties.SupportTicket;

public interface HelpDeskFacade {
	
	void addNewSupportTicket(SupportTicket supportTicket);
	
	SupportTicket getNextSupportTicket();

	/**
	 * @return amount of tickets that are not processed
	 */
	int getNumberOfTickets();
}
