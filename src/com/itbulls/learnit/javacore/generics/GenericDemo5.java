package com.itbulls.learnit.javacore.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo5 {

	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<>();
		
		List list = new ArrayList();
		list = integers;
		list.add("some string");
		
		Integer integer = integers.get(0);
		System.out.println(integer);
		
	}
}
