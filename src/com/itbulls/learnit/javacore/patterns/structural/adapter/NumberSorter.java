package com.itbulls.learnit.javacore.patterns.structural.adapter;

import java.util.Collections;
import java.util.List;

/* This is our adaptee, a third party implementation of a  
 * number sorter that deals with Lists, not arrays. */
public class NumberSorter {
	public List<Integer> sortList(List<Integer> numbers) {
		Collections.sort(numbers);
		return numbers;
	}
}
