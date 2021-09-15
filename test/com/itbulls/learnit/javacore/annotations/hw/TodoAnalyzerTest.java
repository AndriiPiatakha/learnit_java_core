package com.itbulls.learnit.javacore.annotations.hw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.itbulls.learnit.javacore.annotations.hw.Todo.Priority;
import com.itbulls.learnit.javacore.annotations.hw.Todo.Status;

public class TodoAnalyzerTest {
	
	private TodoAnalyzer todoAnalyzer;
	
	@Before
	public void setUp() {
		todoAnalyzer = new TodoAnalyzer();
	}
	
	@Test
	public void shouldBeDefaultLowPriority() throws NoSuchMethodException, SecurityException {
		Priority actualPriority = BusinessLogic.class.getMethod("incompleteMethod2")
				.getAnnotation(Todo.class).priority();
	
		assertEquals(Todo.Priority.LOW, actualPriority);
	}
	
	@Test
	public void shouldBeDefaultNotStartedStatus() throws NoSuchMethodException, SecurityException {
		 Status actualStatus = BusinessLogic.class.getMethod("notYetStartedMethod")
			.getAnnotation(Todo.class).status();
		 assertEquals(Todo.Status.NOT_STARTED, actualStatus);
	}
	
	@Test
	public void shouldGenerateReportFollowingPattern() {
		String todoReport = todoAnalyzer.getTodoReport(BusinessLogic.class);
		System.out.println(todoReport);
		assertTrue(todoReport.contains("method name: notYetStartedMethod, author: Andrey, priority: HIGH, status: NOT_STARTED"));
		assertTrue(todoReport.contains("method name: incompleteMethod1, author: Yegor, priority: MEDIUM, status: STARTED"));
		assertTrue(todoReport.contains("method name: incompleteMethod2, author: Dima, priority: LOW, status: STARTED"));
	}
	
	
	
	
	
	private static class BusinessLogic {

	    public void compltedMethod() {
	        System.out.println("This method is complete");
	    }    
	    
	    @Todo(priority = Todo.Priority.HIGH, author = "Andrey")
	    public void notYetStartedMethod() {
	        // Method that wasn't started yet
	    }
	    
	    @Todo(priority = Todo.Priority.MEDIUM, author = "Yegor", status = Todo.Status.STARTED)
	    public void incompleteMethod1() {
	        // Some method that is not finished yet
	    }

	    @Todo(author = "Dima", status = Todo.Status.STARTED )
	    public void incompleteMethod2() {
	    	// Some method that is not finished yet with Low priority
	    }
	}

}
