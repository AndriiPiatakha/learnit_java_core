package com.itbulls.learnit.javacore.powermock;

import static org.powermock.api.mockito.PowerMockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({String.class, ClassWithStaticMethodExample.class})
//@PrepareForTest(fullyQualifiedNames = "com.itbulls.learnit.javacore.powermock.*")
public class PowerMockExampleSourceTest {

	@Test
	public void shouldMockStaticMethod() {
		mockStatic(ClassWithStaticMethodExample.class);
		when(ClassWithStaticMethodExample.getNumber()).thenReturn(10);
		assertThat(ClassWithStaticMethodExample.getNumber(), equalTo(10));
		assertThat(ClassWithStaticMethodExample.getSomeRandomString(), equalTo(null));
		
		verifyStatic(ClassWithStaticMethodExample.class, times(1));
		ClassWithStaticMethodExample.getNumber();
	}
	
	@Test
	public void shouldMockFinalClass() {
		String stringMock = mock(String.class);
		when(stringMock.length()).thenReturn(20);
		assertThat(stringMock.length(), equalTo(20));
		
		// can mock hashCode and equals() 
		when(stringMock.hashCode()).thenReturn(1);
		assertThat(stringMock.hashCode(), equalTo(1));
		
		when(stringMock.equals("1")).thenReturn(true);
		assertThat(stringMock.equals("1"), is(true));
	}
	
	@Test
	public void shouldMockNativeMethods() {
		// can mock native methods
		var obj = mock(Object.class);
		when(obj.hashCode()).thenReturn(2);
		assertThat(obj.hashCode(), equalTo(2));
	}
	
	@Test
	public void shouldMockConstructor() throws Exception {
		var obj = new ClassWithStaticMethodExample();
		obj.setI(2);
		obj.setS("random string");
		
		whenNew(ClassWithStaticMethodExample.class).withNoArguments().thenReturn(obj);
		
		assertThat(new ClassWithStaticMethodExample().getI(), equalTo(2));
		assertThat(new ClassWithStaticMethodExample().getS(), equalTo("random string"));
		
		verifyNew(ClassWithStaticMethodExample.class, times(2)).withNoArguments();
	}
	
	@Test
	public void shouldMockConstructorWithArguments() throws Exception {
		var obj = new ClassWithStaticMethodExample(2, "random string");
		
		whenNew(ClassWithStaticMethodExample.class)
				.withArguments(anyInt(), anyString())
				.thenReturn(obj);
		
		assertThat(new ClassWithStaticMethodExample(10, "").getI(), equalTo(2));
		assertThat(new ClassWithStaticMethodExample(21, "asd").getS(), equalTo("random string"));
		
		verifyNew(ClassWithStaticMethodExample.class, times(2))
						.withArguments(anyInt(), anyString());
	}
	
	@Test
	public void shouldMockSpyObjects() {
		spy(ClassWithStaticMethodExample.class);
		
		when(ClassWithStaticMethodExample.getNumber()).thenReturn(1);
		
		assertThat(ClassWithStaticMethodExample.getNumber(), equalTo(1));
		assertThat(ClassWithStaticMethodExample.getSomeRandomString(), 
				equalTo("random string"));
	}
	
	@Test
	public void shouldMockFinalMethod() {
		var mock = mock(ClassWithStaticMethodExample.class);
		
		when(mock.finalMethodExample()).thenReturn("final method is mocked");
		
		assertThat(mock.finalMethodExample(), equalTo("final method is mocked"));
		verify(mock).finalMethodExample();
	}
	
	@Test
	public void shouldMockPrivateMethod() throws Exception {
		var testObject = new ClassWithStaticMethodExample();
		var spy = spy(testObject);
		
		when(spy, "privateMethodExample").thenReturn("private method is mocked");
		
		assertThat(spy.callPrivateMethod(), equalTo("private method is mocked"));
		verifyPrivate(spy).invoke("privateMethodExample");
	}
}



class ClassWithStaticMethodExample {
	private int i;
	private String s;
	
	public ClassWithStaticMethodExample() {
	}
	
	

	public ClassWithStaticMethodExample(int i, String s) {
		this.i = i;
		this.s = s;
	}

	public static int getNumber() {
		System.out.println(5 / 0);
		return 1;
	}
	
	public static String getSomeRandomString() {
		return "random string";
	}
	
	public final String finalMethodExample() {
		return "final method";
	}
	
	private String privateMethodExample() {
		return "private method";
	}
	
	public String callPrivateMethod() {
		return privateMethodExample();
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
	
}
