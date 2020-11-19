package com.itbulls.learnit.javacore.jcf.collections.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

public class IteratorDemo {

	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

		
		System.out.println("========== Iterator demo ==========");
		
		Iterator<Integer> iterator = integers.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("========== Iterator - can't be reset automatically ==========");
		if (!iterator.hasNext()) {
			System.out.println("If we are in this section that means there is no other elements in our iterator.");
		}
		
		System.out.println("========== Iterator - remove demo ==========");
		iterator = integers.iterator();
		while (iterator.hasNext()) {
			int nextInt = iterator.next();
			if (nextInt % 2 == 0) {
				iterator.remove();
			}
		}
		System.out.println(integers);
		
//		System.out.println("========== Iterator - remove - error demo ==========");
//		iterator = integers.iterator();
//		iterator.remove();
		
//		System.out.println("========== Iterator - Concurrent Modification error demo ==========");
//		iterator = integers.iterator();
//		while (iterator.hasNext()) {
//			integers.remove(0);
//			int nextElement = iterator.next();
//			System.out.println(nextElement);
//		}
		
		
		System.out.println("========== Iterator - Fail-safe iterator demo ==========");
		List<Integer> threadSafeList = new CopyOnWriteArrayList<>(integers);
		iterator = threadSafeList.iterator();
		threadSafeList.add(100);
		while (iterator.hasNext()) {
			threadSafeList.remove(0);
			int nextElement = iterator.next();
			System.out.println(nextElement);
		}
		System.out.println(threadSafeList);
		
		
		System.out.println("========== Iterator - Weakly consistent iterator demo ==========");
		Collection<Integer> deque = new ConcurrentLinkedDeque<>(integers);
		iterator = deque.iterator();
		deque.add(100);
		while (iterator.hasNext()) {
			int nextElement = iterator.next();
			System.out.println(nextElement);
		}
		System.out.println(deque);
	}

}
