package com.itbulls.learnit.javacore.enumerations.hw;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MessageTypeTest {
	
	@Test
	public void shouldReturnPriorityForA() {
		assertEquals(Priority.HIGH, MessageType.A.getPriority());
	}
	
	@Test
	public void shouldReturnPriorityForB() {
		assertEquals(Priority.MEDIUM, MessageType.B.getPriority());
	}
	
	@Test
	public void shouldReturnPriorityForC() {
		assertEquals(Priority.LOW, MessageType.C.getPriority());
	}
	
	@Test
	public void shouldReturnPriorityForD() {
		assertEquals(Priority.LOW, MessageType.D.getPriority());
	}

}
