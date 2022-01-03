package com.itbulls.learnit.javacore.dao.hw.template.helpdesk.facades.impl;

import java.util.PriorityQueue;
import java.util.Queue;

import com.itbulls.learnit.javacore.dao.hw.template.helpdesk.enteties.SupportTicket;
import com.itbulls.learnit.javacore.dao.hw.template.helpdesk.facades.HelpDeskFacade;
import com.itbulls.learnit.javacore.dao.hw.template.helpdesk.utils.CustomSupportTicketsComparator;

public class DefaultHelpDeskFacade implements HelpDeskFacade {
	
	private Queue<SupportTicket> tickets;
	
	{
		tickets = new PriorityQueue<>(new CustomSupportTicketsComparator());
	}

	@Override
	public void addNewSupportTicket(SupportTicket supportTicket) {
		tickets.offer(supportTicket);
	}

	@Override
	public SupportTicket getNextSupportTicket() {
		return tickets.poll();
	}

	@Override
	public int getNumberOfTickets() {
		return tickets.size();
	}

}
