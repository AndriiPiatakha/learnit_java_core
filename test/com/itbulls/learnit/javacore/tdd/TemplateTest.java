package com.itbulls.learnit.javacore.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TemplateTest {
	
	@Test
	void shouldSetValueIntoPlaceholder() {
		// GIVEN
		Template template = new Template("Hello, ${firstName}");
		
		// WHEN
	    template.set("firstName", "John"); 
	    String emailText = template.createEmailText();
	    
	    // THEN
	    assertEquals("Hello, John", emailText);
	}
	
	@Test
	void shouldProcessDifferentValues() {
		// GIVEN
		Template template = new Template("Hello, ${firstName}");
		
		// WHEN
	    template.set("firstName", "William"); 
	    String emailText = template.createEmailText();
	    
	    // THEN
	    assertEquals("Hello, William", emailText);
	}
	
	@Test
	void shouldProcessDifferentMailTemplates() {
		// GIVEN
		Template template = new Template("Hi, ${firstName}");
		
		// WHEN
	    template.set("firstName", "William"); 
	    String emailText = template.createEmailText();
	    
	    // THEN
	    assertEquals("Hi, William", emailText);
	}
	
	@Test
	void shouldProcessDifferentPlaceholdersAndDifferentValues() {
		// GIVEN
		Template template = new Template("Hello dear ${firstName} ${lastName}");
		
		// WHEN
	    template.set("firstName", "William"); 
	    template.set("lastName", "Harison"); 
	    String emailText = template.createEmailText();
	    
	    // THEN
	    assertEquals("Hello dear William Harison", emailText);
	}
	
	@Test
	void shouldThrowExceptionWhenNotAllVariablesArePopulated() {
		// GIVEN
		Template template = new Template("Hello dear ${firstName} ${lastName}");
		
	    // WHEN
	    RuntimeException exception = assertThrows(RuntimeException.class, () -> {
	    	template.createEmailText();
	    });
	    
	    //THEN
	    assertEquals("Not enough values for template", exception.getMessage());
	}

}
