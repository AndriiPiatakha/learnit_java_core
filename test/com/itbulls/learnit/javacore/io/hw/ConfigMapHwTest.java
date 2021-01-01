package com.itbulls.learnit.javacore.io.hw;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ConfigMapHwTest {
	
	private ConfigMapHw testInstance;
	
	@Before
	public void setUp() {
		testInstance = new ConfigMapHw();
	}
	
	@Test
	public void shouldReadPropertyByNameDiscount() throws IOException {
		String value = testInstance.getValueFromConfigMap("configMap.txt", "discount");
		assertEquals("0.07", value);
	}
	
	@Test
	public void shouldReadPropertyByNameDatabaseUserName() throws IOException {
		String value = testInstance.getValueFromConfigMap("configMap.txt", "database.user");
		assertEquals("testUser", value);
	}
	
	@Test
	public void shouldReadPropertyByNameDatabaseUserPassword() throws IOException {
		String value = testInstance.getValueFromConfigMap("configMap.txt", "database.password");
		assertEquals("testPassword", value);
	}
	
	@Test
	public void shouldIgnoreNullValueForPath() throws IOException {
		testInstance.getValueFromConfigMap(null, "database.password");
	}
	
	@Test
	public void shouldIgnoreNullValueForKeyNamse() throws IOException {
		testInstance.getValueFromConfigMap("configMap.txt", null);
	}

}
