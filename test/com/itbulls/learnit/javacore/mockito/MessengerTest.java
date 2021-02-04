package com.itbulls.learnit.javacore.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;

//@RunWith(MockitoJUnitRunner.class)			// in JUnit 4
@ExtendWith(MockitoExtension.class)
public class MessengerTest {
	
    private static final String RANDOM_MESSAGE = "Message";
	private static final String RANDOM_EMAIL = "email@email.com";
    
	// One of the ways to initialize mocks marked with annotation in JUnit 4
//    @Rule
//    public MockitoRule rule = MockitoJUnit.rule();
	
	
	@Mock
    private TemplateEngine templateEngineMock;
    @Mock
    private MailServer mailServerMock;
    @InjectMocks
    private Messenger messenger;
    @Captor
    private ArgumentCaptor<Email> captor;
    
    private AutoCloseable closeble;
    
 
    
    @BeforeEach
    void setUp() {
    	// We can create mock based on the Interface or a Class
//    	templateEngine = mock(TemplateEngine.class);	
    	
    	// init mock with annotations
//    	MockitoAnnotations.initMocks(this);
    	
    	// just another version of initilization of mocks with annotation
    	// pay attention to tear down method - we have to call close method
//    	closeble = MockitoAnnotations.openMocks(this);
    }
    
    @AfterEach
    void tearDown() throws Exception {
//    	closeble.close();
    }
    
    @Test
    void shouldSendMessage() {
    	// given
    	var client = new Client(RANDOM_EMAIL);
    	var template = new Template();
    	when(templateEngineMock.prepareMessage(client, template))
    			.thenReturn(RANDOM_MESSAGE);
    	
//    	 row below will print RANDOM_MESSAGE
//    	System.out.println(templateEngineMock
//    			.prepareMessage(client, template));
    	
    	// row below will print null
//    	System.out.println(templateEngineMock
//    			.prepareMessage(new Client(RANDOM_EMAIL), new Template()));
    	
    	// when
        messenger.sendMessage(client, template);

        // then
        verify(templateEngineMock).prepareMessage(client, template);
        verify(mailServerMock).send(any(Email.class));
    }

    
    @Test
    void shouldSendMessageWithArgumentMatchers() {
    	// given
    	var client = new Client(RANDOM_EMAIL);
    	var template = new Template();
    	when(templateEngineMock.prepareMessage(any(Client.class), 
    			any(Template.class))).thenReturn(RANDOM_EMAIL);
    	/*
    	 * Other possible matchers:
    	 * - anyString()
    	 * - anyInt()
    	 * - etc
    	 */
    	
    	
    	// this statements will throw an exception
//    	when(templateEngineMock.prepareMessage(client, any(Template.class)))
//    		.thenReturn(RANDOM_EMAIL);
    	
    	// write this statement instead with eq() argument matcher
//    	when(templateEngineMock.prepareMessage(eq(client), any(Template.class)))
//			.thenReturn(RANDOM_EMAIL);
    	
    	/*
    	 * Also otehr matchers available:
    	 * - eq()
    	 * - isA(Class type)
    	 * - isNull()
    	 * - isNotNull()
    	 * - matches(regex)
    	 * - etc
    	 */
    	
    	// when
        messenger.sendMessage(client, template);

        // then
        verify(templateEngineMock).prepareMessage(client, template);
        verify(mailServerMock).send(any(Email.class));
    }
    
    
    @Test
    public void shouldThrowExceptionWhenTemplateEngineThrowsException() {
    	// given
    	var client = new Client(RANDOM_EMAIL);
    	var template = new Template();
        when(templateEngineMock.prepareMessage(
        		client, template))
        		.thenThrow(new IllegalArgumentException());

        // when & then
        assertThrows(IllegalArgumentException.class, () -> 
        	messenger.sendMessage(client, template)
        );
    }
    
    @Test
    public void shouldSetClientEmailToAddresseInEmail() {
    	// given
    	var client = new Client(RANDOM_EMAIL);
    	var template = new Template();
    	when(templateEngineMock.prepareMessage(client, template))
    			.thenReturn(RANDOM_MESSAGE);

        messenger.sendMessage(client, template);

        verify(templateEngineMock).prepareMessage(client, template);
        verify(mailServerMock).send(captor.capture());
        assertEquals(client.getEmail(), captor.getValue().getAddressee());
    }


}

