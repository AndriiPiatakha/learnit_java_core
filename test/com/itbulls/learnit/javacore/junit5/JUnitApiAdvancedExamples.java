package com.itbulls.learnit.javacore.junit5;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.condition.JRE.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.api.condition.JRE;

@Tag("production")

/*
 * There are different test method order implementation. They are: 
 * - DisplayName
 * - MethodName 
 * - OrderAnnotation 
 * - Random
 * 
 */
@TestMethodOrder(OrderAnnotation.class)
public class JUnitApiAdvancedExamples {

	@Test
	@Tag("production")
	void someTestForProdEnv() {
	}

	@Test
	@Order(1)
	void order1() {
		// perform assertions against null values
	}

	@Test
	@Order(2)
	void order2() {
		// perform assertions against empty values
	}

	@Test
	@Order(3)
	void order3() {
		// perform assertions against valid values
	}
	
	// ===================== Test Conditions Examples
	
	/*
	 * There are such groups of conditions:
		-	Operating System conditions
		-	Java Runtime Environments conditions
		-	System Property Conditions
		-	Environment Variable Conditions
		-	Custom conditions
	 * 
	 */
	
	
	// *** Operating System Conditions
	@Test
	@EnabledOnOs(OS.MAC)
	void onlyOnMacOs() {
	}

	@Test
	@EnabledOnOs({ OS.LINUX, OS.MAC })
	void onLinuxOrMac() {
	}

	@Test
	@DisabledOnOs(OS.WINDOWS)
	void notOnWindows() {
	}
	
	// **** JRE Conditions
	
	@Test
	@EnabledOnJre(JAVA_8)
	void onlyOnJava8() {
	}

	@Test
	@EnabledOnJre({ JAVA_9, JAVA_10 })
	void onJava9Or10() {
	}

	@Test
	@EnabledForJreRange(min = JAVA_9, max = JAVA_11)
	void fromJava9to11() {
	}

	@Test
	@EnabledForJreRange(min = JAVA_9)
	void fromJava9toCurrentJavaFeatureNumber() {
	}

	@Test
	@EnabledForJreRange(max = JAVA_11)
	void fromJava8To11() {
	}

	@Test
	@DisabledOnJre(JAVA_9)
	void notOnJava9() {
	}

	@Test
	@DisabledForJreRange(min = JAVA_9, max = JAVA_11)
	void notFromJava9to11() {
	}

	@Test
	@DisabledForJreRange(min = JAVA_9)
	void notFromJava9toCurrentJavaFeatureNumber() {
	}

	@Test
	@DisabledForJreRange(max = JAVA_11)
	void notFromJava8to11() {
	}
	
	// *** System properties conditions
	
	@Test
	@EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
	void onlyOn64BitArchitectures() {
	}

	@Test
	@DisabledIfSystemProperty(named = "ci-server", matches = "true")
	void notOnCiServer() {
	}
	
	// *** Environment variables conditions
	
	@Test
	@EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
	void onlyOnStagingServer() {
	}

	@Test
	@DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
	void notOnDeveloperWorkstation() {
	}
	
	// *** Custom conditions
	
	@Test
	@EnabledIf("customCondition")
	void enabled() {
	}

	@Test
	@DisabledIf("customCondition")
	void disabled() {
	}

	boolean customCondition() {
	    return true;
	}
	
	// ===================== Repeated test
	
//	@RepeatedTest(10)
	@RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
	void repeatedTest() {
	}
	
	
	// ===================== Extension - TempDir
	
	@Test
	void tempDirExample(@TempDir Path tempDir) throws IOException {
		Path path = tempDir.resolve("test");
		Files.write(path, "some text".getBytes());
		
		assertEquals("some text", Files.readAllLines(path).stream().collect(Collectors.joining()));
	}

}
