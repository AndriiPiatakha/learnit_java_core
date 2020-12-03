package com.itbulls.learnit.javacore.functions.lambdaandmethodreference;

@FunctionalInterface
public interface DistanceCalculator {
	
	double calculateDistance(City city1, City City2);
	
	// in FunctionalInterface it is forbidden to have two abstract methods
//	double calculateDeliveryTime(); 
	
	default void someDefaultMethod() {};
	
	static void someStaticMethod() {};

}
