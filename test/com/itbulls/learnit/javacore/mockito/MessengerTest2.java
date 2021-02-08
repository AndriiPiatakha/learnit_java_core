package com.itbulls.learnit.javacore.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.*;
import static org.mockito.AdditionalMatchers.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;

//@RunWith(MockitoJUnitRunner.class)			// in JUnit 4
@ExtendWith(MockitoExtension.class)
public class MessengerTest2 {
	
    private static final String RANDOM_MESSAGE = "Message";
	private static final String RANDOM_EMAIL = "email@email.com";
    
	// One of the ways to initialize mocks marked with annotation in JUnit 4
//    @Rule
//    public MockitoRule rule = MockitoJUnit.rule();
	
	
	@Mock
    private TemplateEngine templateEngineMock;
	
	/*
	 * Other possible answers:
	  	-	CALLS_REAL_METHODS
		-	RETURNS_DEFAULTS
		-	RETURNS_MOCKS
		-	RETURNS_SELF
		-	RETURNS_SMART_NULLS

	 */
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private MailServer mailServerMock;
    @InjectMocks
    private Messenger messenger;
    @Captor
    private ArgumentCaptor<Email> captor;
    
    private AutoCloseable closeble;
    
    @Spy
    private ArrayList<Integer> list;
 
    
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


    
//    =================================== examples 2 - MockitoAdvanced Features
    
    @Test
    void shouldSendMessageOnlyOneTime() {
    	// given
    	var client = new Client(RANDOM_EMAIL);
    	var template = new Template();
    	when(templateEngineMock.prepareMessage(client, template))
    			.thenReturn(RANDOM_MESSAGE);
    	
    	// when
        messenger.sendMessage(client, template);

        // then
        verify(templateEngineMock, times(1)).prepareMessage(client, template);
        verify(mailServerMock, times(1)).send(any(Email.class));
        
        
        verify(mailServerMock, atLeastOnce()).send(any(Email.class));
        verify(mailServerMock, atLeast(1)).send(any(Email.class));
        verify(mailServerMock, atMost(1)).send(any(Email.class));
//        verify(mailServerMock, never()).send(any(Email.class)); // this will fail
    }
    
    
    @Test
    void shouldSendMessageAndPrepareTemplateBeforeThat() {
    	// given
    	var inOrder = inOrder(templateEngineMock, mailServerMock);
    	var client = new Client(RANDOM_EMAIL);
    	var template = new Template();
    	when(templateEngineMock.prepareMessage(client, template))
    			.thenReturn(RANDOM_MESSAGE);
    	
    	// when
        messenger.sendMessage(client, template);

        // then
        inOrder.verify(templateEngineMock).prepareMessage(client, template);
        inOrder.verify(mailServerMock).send(any(Email.class));
        
        // Like this test will fail
//        inOrder.verify(mailServerMock).send(any(Email.class));
//        inOrder.verify(templateEngineMock).prepareMessage(client, template);
    }
    
    
    @Test
    void shouldSendMessageAndThereIsNoMoreInteractionsWithTemplateEngine() {
    	// given
    	var inOrder = inOrder(templateEngineMock, mailServerMock);
    	var client = new Client(RANDOM_EMAIL);
    	var template = new Template();
    	when(templateEngineMock.prepareMessage(client, template))
    			.thenReturn(RANDOM_MESSAGE);
    	
    	
    	// when
        messenger.sendMessage(client, template);

        // then
        inOrder.verify(templateEngineMock).prepareMessage(client, template);
        inOrder.verify(mailServerMock).send(any(Email.class));
        verifyNoMoreInteractions(templateEngineMock, mailServerMock);
        
//        In this case verifyNoMoreInteractions will throw an exception
//        templateEngineMock.evaluateTemplate(null);
//        verifyNoMoreInteractions(templateEngineMock);
        
    }
    
    @Test
    void shouldCallRealMethodOnMockExample() {
    	Client client = new Client("");
		Template template = new Template();
		
		// null is returned
		System.out.println(templateEngineMock.prepareMessage(client, template));
		
		when(templateEngineMock.prepareMessage(client, template)).thenCallRealMethod();
		// 'Some template' will be returned - because that is the result of prepare message 
		System.out.println(templateEngineMock.prepareMessage(client, template));
    }
    
    
    @Test
    void shouldNotThrowExceptionWithDeepStub() {
    	// given
    	var client = new Client(RANDOM_EMAIL);
    	var template = new Template();

        var validator = mailServerMock.getValidator();
        
        // this line will throw NPE without DEEP STUBS
        validator.validate(new Email());
    }
    
    @Test
    void additionalMatchersDemo() {
    	List<String> listMock = mock(List.class);
    	
//    	when(listMock.get(or(eq(1), eq(2)))).thenReturn("more");
//    	when(listMock.get(gt(2))).thenThrow(new RuntimeException());
//    	
//    	System.out.println(listMock.get(1)); // more is returned
//    	System.out.println(listMock.get(2)); // more is returned
//    	System.out.println(listMock.get(3)); // RuntimeException is thrown

    	
    	/* There are other matchers, such as:
    	 * - or()
    	 * - not()
    	 * - lt()		- less than
    	 * - leq()		- less than or equal to
    	 * - gt()		- greater than
    	 * - geq()		- greater than or equal to
    	 * - find(regex)
    	 * - eq()
    	 * - cmpEq()	
    	 * - aryEq()
    	 * - and()
    	 * 
    	 * 
    	 */
    	
    }
    
    @Test
    void verifyVoidMethodExample() {
    	List<String> listMock = mock(List.class);
    	
    	// You can't use when method like below with void methods
//    	when(listMock.add(1, "first argumnet")).thenThrow(new IllegalArgumentException());
    	
    	// instead you can set behavior to void methods like this
//    	doThrow(IllegalArgumentException.class).when(listMock).add(1, "first argumnet");
//    	listMock.add(1, "");
    	
    	
    	
    	
//    	ArgumentCaptor<Comparator<String>> captor = ArgumentCaptor.forClass(Comparator.class);
//    	doNothing().when(listMock).sort(captor.capture());
    	
    	
    	
    	doAnswer(methodInvocation -> {
            Object arg0 = methodInvocation.getArgument(0);
            Object arg1 = methodInvocation.getArgument(1);
            
            assertEquals(3, arg0);
            assertEquals("List Element", arg1);
            return null;
        }).when(listMock).add(any(Integer.class), any(String.class));
    	listMock.add(3, "List Element");
    }
    
    
    @Test
	public void shouldThrowExceptionWhenMockFinalClass() {
    	// Can't mock final class
//		String string = mock(String.class);
//		when(string.length()).thenReturn(20);
//		assertThat(string.length(), equalTo(20));
		
		// Can't mock static method
//		when(Map.of()).thenReturn(null);
    	
    	// Can't mock equals of hashCode
    	
	}
    
    @Test
    void spyExample() {
    	List<Integer> listInts = new ArrayList<>();
    	List<Integer> spy = spy(listInts);
    	
    	// OutOfBoundsException because get method is called on real list that is empty
//    	when(spy.get(0)).thenReturn(0); 
    	
    	doReturn(0).when(spy).get(0);
    	System.out.println(spy.get(0));
    	
    	verify(spy).get(0);
    }
    
   
}

