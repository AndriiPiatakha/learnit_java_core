package com.itbulls.learnit.javacore.jcf.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
	
	public static void main(String[] args) {
		
		List list1 = new ArrayList();
		List<String> list2 = new ArrayList<>();
		
		// === non-generic list demo
		list1.add("some string");
		list1.add(1);
		Object object = list1.get(1);
		System.out.println(object);
		
		// === generic list demo
		list2.add("some string");
//		list2.add(1); // COMPILATION ERROR! Can't add integer
		String string = list2.get(0);
		System.out.println(string);
		
		//=== LinkedList
		list2 = new LinkedList<>();
		list2.add("another string");
		System.out.println(list2.get(0));
		
		//=== initialization demo
		List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3));
		System.out.println(list3.get(1));
		
		//=== List toString demo
		System.out.println(list3);
		
		//=== foreach demo
		for (Integer i : list3) {
			System.out.println(i);
		}
		
		//=== clear() demo
		list3.clear();
		System.out.println(list3);
	}

}
