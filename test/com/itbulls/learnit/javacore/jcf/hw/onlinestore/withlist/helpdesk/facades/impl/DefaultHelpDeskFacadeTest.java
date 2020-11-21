package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.helpdesk.facades.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.helpdesk.enteties.Priority;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.helpdesk.enteties.RequestType;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.helpdesk.enteties.SupportTicket;
import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.helpdesk.enteties.impl.DefaultSupportTicket;

public class DefaultHelpDeskFacadeTest {
	
	private DefaultHelpDeskFacade testInstance;
	
	@Before
	public void setUp() {
		testInstance = new DefaultHelpDeskFacade();
	}
	
	@Test
	public void shouldReturnNumberOfTicketsInHelpDesk() {
		assertEquals(0, testInstance.getNumberOfTickets());
	}
	
	@Test
	public void shouldAddTicketToHelpDesk() {
		testInstance.addNewSupportTicket(new DefaultSupportTicket());
		testInstance.addNewSupportTicket(new DefaultSupportTicket());
		
		assertEquals(2, testInstance.getNumberOfTickets());
	}
	
	@Test
	public void shouldReturnTicketWithTheHighPriority() {
		testInstance.addNewSupportTicket(
				new DefaultSupportTicket(RequestType.OTHER));
		testInstance.addNewSupportTicket(
				new DefaultSupportTicket(RequestType.ACCOUNT_IS_HACKED));
		testInstance.addNewSupportTicket(
				new DefaultSupportTicket(RequestType.COOPERATION));
		
		assertEquals(Priority.HIGH, testInstance.getNextSupportTicket().getPriority());
	}
	
	@Test
	public void shouldRemoveTicketFromTheQueueWhenGetNextTicketWasCalled() {
		testInstance.addNewSupportTicket(
				new DefaultSupportTicket(RequestType.OTHER));
		testInstance.addNewSupportTicket(
				new DefaultSupportTicket(RequestType.ACCOUNT_IS_HACKED));
		testInstance.addNewSupportTicket(
				new DefaultSupportTicket(RequestType.COOPERATION));
		
		assertEquals(3, testInstance.getNumberOfTickets());
		testInstance.getNextSupportTicket();
		assertEquals(2, testInstance.getNumberOfTickets());
	}
	
	@Test
	public void shouldReturnTheEarliestTicketIfTwoTicketsHaveTheSamePriority() {
		testInstance.addNewSupportTicket(
				new DefaultSupportTicket(RequestType.CAN_NOT_LOGIN));
		testInstance.addNewSupportTicket(
				new DefaultSupportTicket(RequestType.ACCOUNT_IS_BLOCKED));
		
		SupportTicket firstSupportTicket = testInstance.getNextSupportTicket();
		SupportTicket secontSupportTicket = testInstance.getNextSupportTicket();
		assertEquals(RequestType.CAN_NOT_LOGIN, firstSupportTicket.getRequestType());
		assertEquals(RequestType.ACCOUNT_IS_BLOCKED, secontSupportTicket.getRequestType());
		
	}

}
