package com.itbulls.learnit.javacore.patterns.structural.adapter;

public class Demo {
	public static void main(String[] args) {
		  int[] numbers = new int[]{34, 2, 4, 12, 1};  
		  
//		  NumberSorter ns = new NumberSorter();
//		  ns.sort(numbers);
		  
		  Sorter sorter = new SortListAdapter();      
		  sorter.sort(numbers);
	}
}
