package com.itbulls.learnit.javacore.patterns.structural.adapter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortListAdapter implements Sorter {
	private NumberSorter numberSorter;
	
	public SortListAdapter() {
		numberSorter = new NumberSorter();
	}

	@Override
	public int[] sort(int[] numbers) {
		List<Integer> integers = Arrays.stream(numbers).boxed().collect(Collectors.toList());
		numberSorter.sortList(integers);
		return integers.stream().mapToInt(i->i).toArray();
	}

}
