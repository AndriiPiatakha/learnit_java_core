package com.itbulls.learnit.javacore.annotations.hw;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TodoAnalyzer {

	public String getTodoReport(Class<? extends Object> clazz) {
		return Arrays.stream(clazz.getDeclaredMethods())
				.filter(method -> method.getAnnotation(Todo.class) != null)
				.map(method -> {
					var todoAnnotation = method.getAnnotation(Todo.class);
					return "method name: " + method.getName() 
						+ ", author: " + todoAnnotation.author()
						+ ", priority: " + todoAnnotation.priority()
						+ ", status: " + todoAnnotation.status();
				})
				.collect(Collectors.joining(System.lineSeparator()));
	}
}
