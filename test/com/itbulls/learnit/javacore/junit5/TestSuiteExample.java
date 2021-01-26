package com.itbulls.learnit.javacore.junit5;

import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(JUnitPlatform.class)

//By default, it will only include test classes whose names either begin with Test or end with Test or Tests.
@SelectPackages("com.itbulls.learnit.javacore.junit5") 
//@SelectPackages({"com.itbulls.learnit.javacore.junit5","com.itbulls.learnit.javacore.jcf"})

//@SelectPackages("com.itbulls.learnit.javacore") 
//@ExcludePackages("com.itbulls.learnit.javacore.junit5")
//@IncludePackages("com.itbulls.learnit.javacore.oop")

@IncludeTags("production")
//@ExcludeTags("development")

@SelectClasses( JUnitApiAdvancedExamples.class )
//@SelectClasses( {CalculatorTests.class, MoneyTransactionServiceTest.class} )
public class TestSuiteExample {

}
