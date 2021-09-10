package com.itbulls.learnit.javacore.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class TestRunner {
	
	public void runTests(Class clazz) {
		Method[] methods = clazz.getDeclaredMethods();
		Arrays.stream(methods)
				.filter(method -> method.getAnnotation(Test.class) != null)		// with our annotation
				.filter(method -> !Modifier.isStatic(method.getModifiers()))	// non-static methods only
				.forEach(method -> {
					try {
						var obj = clazz.getConstructor().newInstance();
						var testAnnotation = method.getAnnotation(Test.class);
						if (!testAnnotation.expected().equals(Test.None.class)) {
							try {
								method.invoke(obj);
							} catch (InvocationTargetException t) {
								if (!t.getCause().getClass().equals(testAnnotation.expected())) {
									System.out.println("Test with name \"" 
											+ testAnnotation.name() + "\" is failed.");
									return;
								}
							}
						} else {
							method.invoke(obj);
							
						}
						System.out.println("Test with name \"" 
								+ testAnnotation.name() + "\" is passed successfully.");
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}
				});;
	}
	
	
}
