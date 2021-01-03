package com.itbulls.learnit.javacore.io.hw;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class ConfigMapHwTest {
	
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();
	
	private ConfigMapHw testInstance;
	private File tempConfigMapFile;
	
	@Before
	public void setUp() {
		testInstance = new ConfigMapHw();
		
		try {
			this.tempConfigMapFile = tempFolder.newFile();
			String configString = "discount=0.07" + System.lineSeparator()
					+ "database.user=testUser" + System.lineSeparator()
					+ "database.password=testPassword";
			
			Files.write(tempConfigMapFile.toPath(), configString.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void shouldReadPropertyByNameDiscount() throws IOException {
		String value = testInstance.getValueFromConfigMap(this.tempConfigMapFile.toPath(), "discount");
		assertEquals("0.07", value);
	}
	
	@Test
	public void shouldReadPropertyByNameDatabaseUserName() throws IOException {
		String value = testInstance.getValueFromConfigMap(this.tempConfigMapFile.toPath(), "database.user");
		assertEquals("testUser", value);
	}
	
	@Test
	public void shouldReadPropertyByNameDatabaseUserPassword() throws IOException {
		String value = testInstance.getValueFromConfigMap(this.tempConfigMapFile.toPath(), "database.password");
		assertEquals("testPassword", value);
	}
	
	@Test
	public void shouldIgnoreNullValueForPath() throws IOException {
		testInstance.getValueFromConfigMap(null, "database.password");
	}
	
	@Test
	public void shouldIgnoreNullValueForKeyNamse() throws IOException {
		testInstance.getValueFromConfigMap(this.tempConfigMapFile.toPath(), null);
	}

}
