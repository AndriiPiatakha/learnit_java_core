package com.itbulls.learnit.javacore.jcf.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapSortingDemo {
	
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(2, "two");
		map.put(1, "one");
		map.put(3, "three");
		
		System.out.println("========== Sorting Map by Comparable Key ==========");
		List<Entry<Integer, String>> list = 
				new ArrayList<Entry<Integer, String>>(map.entrySet());
		
		Collections.shuffle(list);
		System.out.println("Entries before sorting: " + list);
		
		list.sort(Entry.comparingByKey());
		
		System.out.println("Entries after sorting: " + list);
		
		// ========== Sorting Map by Comparable Key with TreeMap
		Map<Integer, String> sortedMap = 
				new TreeMap<>(map);
		
		System.out.println("Elements in TreeMap: " + sortedMap);
		
		// ========== Sorting Map by Comparable Value
		
		Collections.shuffle(list);
		System.out.println("Entries before sorting: " + list);
		
		list.sort(Entry.comparingByValue());
		
		Collections.sort(list, Entry.comparingByValue());	
		
		System.out.println("Entries after sorting by value: " + list);
		
		Map<Integer, String> map2 = Map.ofEntries(list.toArray(Entry[]::new));
	}

}
