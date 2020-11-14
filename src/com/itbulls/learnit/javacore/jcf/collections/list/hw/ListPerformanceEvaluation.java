package com.itbulls.learnit.javacore.jcf.collections.list.hw;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceEvaluation {

	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<>();

		fillOutList(arrayList, 1_000_000);
		fillOutList(linkedList, 1_000_000);

		System.out.println("=========== ARRAY LIST ===========");

		// ============== 100 elements

		long mill = System.nanoTime();
		addElementsToBeginning(arrayList, 100);
		long add100ElementArrayListBeginning = (System.nanoTime() - mill) / 10000;

		System.out.println("100 element added into the beginning: "
				+ add100ElementArrayListBeginning);

		arrayList = new ArrayList<>();
		fillOutList(arrayList, 1_000_000);
		mill = System.nanoTime();
		addElementsToMiddle(arrayList, 100);
		long add100ElementArrayListMiddle = (System.nanoTime() - mill) / 10000;

		System.out.println(
				"100 element added into the middle: " + add100ElementArrayListMiddle);

		arrayList = new ArrayList<>();
		fillOutList(arrayList, 1_000_000);
		mill = System.nanoTime();
		addElementsToEnd(arrayList, 100);
		long add100ElementArrayListEnd = (System.nanoTime() - mill) / 10000;

		System.out
				.println("100 element added into the end: " + add100ElementArrayListEnd);

		arrayList = new ArrayList<>();
		fillOutList(arrayList, 1_000_000);
		mill = System.nanoTime();
		removeElementsFromBeginning(arrayList, 100);
		long remove100ElementArrayListBeginning = (System.nanoTime() - mill) / 10000;

		System.out.println("100 element removed from the beginning: "
				+ remove100ElementArrayListBeginning);

		arrayList = new ArrayList<>();
		fillOutList(arrayList, 1_000_000);
		mill = System.nanoTime();
		removeElementsFromMiddle(arrayList, 100);
		long remove100ElementArrayListMiddle = (System.nanoTime() - mill) / 10000;

		System.out.println("100 element removed from the middle: "
				+ remove100ElementArrayListMiddle);

		arrayList = new ArrayList<>();
		fillOutList(arrayList, 1_000_000);
		mill = System.nanoTime();
		removeElementsFromEnd(arrayList, 100);
		long remove100ElementArrayListEnd = (System.nanoTime() - mill) / 10000;

		System.out.println(
				"100 element removed from the end: " + remove100ElementArrayListEnd);

		// ============== 10.000 elements

		arrayList = new ArrayList<>();
		fillOutList(arrayList, 1_000_000);
		mill = System.nanoTime();
		addElementsToBeginning(arrayList, 10000);
		long add10000ElementArrayListBeginning = (System.nanoTime() - mill) / 10000;

		System.out.println("10.000 element added into the beginning: "
				+ add10000ElementArrayListBeginning);

		arrayList = new ArrayList<>();
		fillOutList(arrayList, 1_000_000);
		mill = System.nanoTime();
		addElementsToMiddle(arrayList, 10000);
		long add10000ElementArrayListMiddle = (System.nanoTime() - mill) / 10000;

		System.out.println("10.000 element added into the middle: "
				+ add10000ElementArrayListMiddle);

		arrayList = new ArrayList<>();
		fillOutList(arrayList, 1_000_000);
		mill = System.nanoTime();
		addElementsToEnd(arrayList, 10000);
		long add100000ElementArrayListEnd = (System.nanoTime() - mill) / 10000;

		System.out.println(
				"10.000 element added into the end: " + add100000ElementArrayListEnd);

		arrayList = new ArrayList<>();
		fillOutList(arrayList, 1_000_000);
		mill = System.nanoTime();
		removeElementsFromBeginning(arrayList, 10000);
		long remove10000ElementArrayListBeginning = (System.nanoTime() - mill) / 10000;

		System.out.println("10.000 element removed from the beginning: "
				+ remove10000ElementArrayListBeginning);

		arrayList = new ArrayList<>();
		fillOutList(arrayList, 1_000_000);
		mill = System.nanoTime();
		removeElementsFromMiddle(arrayList, 10000);
		long remove100000ElementArrayListMiddle = (System.nanoTime() - mill) / 10000;

		System.out.println("10.000 element removed from the middle: "
				+ remove100000ElementArrayListMiddle);

		arrayList = new ArrayList<>();
		fillOutList(arrayList, 1_000_000);
		mill = System.nanoTime();
		removeElementsFromEnd(arrayList, 10000);
		long remove10000ElementArrayListEnd = (System.nanoTime() - mill) / 10000;

		System.out.println(
				"10.000 element removed from the end: " + remove10000ElementArrayListEnd);

		// ============== 100.000 elements

		arrayList = new ArrayList<>();
		fillOutList(arrayList, 1_000_000);
		mill = System.nanoTime();
		addElementsToBeginning(arrayList, 100_000);
		long add1000000ElementArrayListBeginning = (System.nanoTime() - mill) / 10000;

		System.out.println("100.000 element added into the beginning: "
				+ add1000000ElementArrayListBeginning);

		arrayList = new ArrayList<>();
		fillOutList(arrayList, 1_000_000);
		mill = System.nanoTime();
		addElementsToMiddle(arrayList, 100_000);
		long add1000000ElementArrayListMiddle = (System.nanoTime() - mill) / 10000;

		System.out.println("100.000 element added into the middle: "
				+ add1000000ElementArrayListMiddle);

		arrayList = new ArrayList<>();
		fillOutList(arrayList, 1_000_000);
		mill = System.nanoTime();
		addElementsToEnd(arrayList, 100_000);
		long add10000000ElementArrayListEnd = (System.nanoTime() - mill) / 10000;

		System.out.println(
				"100.000 element added into the end: " + add10000000ElementArrayListEnd);

		arrayList = new ArrayList<>();
		fillOutList(arrayList, 1_000_000);
		mill = System.nanoTime();
		removeElementsFromBeginning(arrayList, 100_000);
		long remove1000000ElementArrayListBeginning = (System.nanoTime() - mill) / 10000;

		System.out.println("100.000 element removed from the beginning: "
				+ remove1000000ElementArrayListBeginning);

		arrayList = new ArrayList<>();
		fillOutList(arrayList, 1_000_000);
		mill = System.nanoTime();
		removeElementsFromMiddle(arrayList, 100_000);
		long remove10000000ElementArrayListMiddle = (System.nanoTime() - mill) / 10000;

		System.out.println("100.000 element removed from the middle: "
				+ remove10000000ElementArrayListMiddle);

		arrayList = new ArrayList<>();
		fillOutList(arrayList, 1_000_000);
		mill = System.nanoTime();
		removeElementsFromEnd(arrayList, 100_000);
		long remove1000000ElementArrayListEnd = (System.nanoTime() - mill) / 10000;

		System.out.println("100.000 element removed from the end: "
				+ remove1000000ElementArrayListEnd);

		System.out.println("=========== LINKED LIST ===========");

		// ============== 100 elements

		mill = System.nanoTime();
		addElementsToBeginning(linkedList, 100);
		long add100ElementLinkedListBeginning = (System.nanoTime() - mill) / 10000;

		System.out.println("100 element added into the beginning: "
				+ add100ElementLinkedListBeginning);

		linkedList = new LinkedList<>();
		fillOutList(linkedList, 1_000_000);
		mill = System.nanoTime();
		addElementsToMiddle(linkedList, 100);
		long add100ElementLinkedListMiddle = (System.nanoTime() - mill) / 10000;

		System.out.println(
				"100 element added into the middle: " + add100ElementLinkedListMiddle);

		linkedList = new LinkedList<>();
		fillOutList(linkedList, 1_000_000);
		mill = System.nanoTime();
		addElementsToEnd(linkedList, 100);
		long add100ElementLinkedListEnd = (System.nanoTime() - mill) / 10000;

		System.out
				.println("100 element added into the end: " + add100ElementLinkedListEnd);

		linkedList = new LinkedList<>();
		fillOutList(linkedList, 1_000_000);
		mill = System.nanoTime();
		removeElementsFromBeginning(linkedList, 100);
		long remove100ElementLinkedListBeginning = (System.nanoTime() - mill) / 10000;

		System.out.println("100 element removed from the beginning: "
				+ remove100ElementLinkedListBeginning);

		linkedList = new LinkedList<>();
		fillOutList(linkedList, 1_000_000);
		mill = System.nanoTime();
		removeElementsFromMiddle(linkedList, 100);
		long remove100ElementLinkedListMiddle = (System.nanoTime() - mill) / 10000;

		System.out.println("100 element removed from the middle: "
				+ remove100ElementLinkedListMiddle);

		linkedList = new LinkedList<>();
		fillOutList(linkedList, 1_000_000);
		mill = System.nanoTime();
		removeElementsFromEnd(linkedList, 100);
		long remove100ElementLinkedListEnd = (System.nanoTime() - mill) / 10000;

		System.out.println(
				"100 element removed from the end: " + remove100ElementLinkedListEnd);

		// ============== 10.000 elements

		linkedList = new LinkedList<>();
		fillOutList(linkedList, 1_000_000);
		mill = System.nanoTime();
		addElementsToBeginning(linkedList, 10000);
		long add10000ElementLinkedListBeginning = (System.nanoTime() - mill) / 10000;

		System.out.println("10.000 element added into the beginning: "
				+ add10000ElementLinkedListBeginning);

		linkedList = new LinkedList<>();
		fillOutList(linkedList, 1_000_000);
		mill = System.nanoTime();
		addElementsToMiddle(linkedList, 10000);
		long add10000ElementLinkedListMiddle = (System.nanoTime() - mill) / 10000;

		System.out.println("10.000 element added into the middle: "
				+ add10000ElementLinkedListMiddle);

		linkedList = new LinkedList<>();
		fillOutList(linkedList, 1_000_000);
		mill = System.nanoTime();
		addElementsToEnd(linkedList, 10000);
		long add100000ElementLinkedListEnd = (System.nanoTime() - mill) / 10000;

		System.out.println(
				"10.000 element added into the end: " + add100000ElementLinkedListEnd);

		linkedList = new LinkedList<>();
		fillOutList(linkedList, 1_000_000);
		mill = System.nanoTime();
		removeElementsFromBeginning(linkedList, 10000);
		long remove10000ElementLinkedListBeginning = (System.nanoTime() - mill) / 10000;

		System.out.println("10.000 element removed from the beginning: "
				+ remove10000ElementLinkedListBeginning);

		linkedList = new LinkedList<>();
		fillOutList(linkedList, 1_000_000);
		mill = System.nanoTime();
		removeElementsFromMiddle(linkedList, 10000);
		long remove100000ElementLinkedListMiddle = (System.nanoTime() - mill) / 10000;

		System.out.println("10.000 element removed from the middle: "
				+ remove100000ElementLinkedListMiddle);

		linkedList = new LinkedList<>();
		fillOutList(linkedList, 1_000_000);
		mill = System.nanoTime();
		removeElementsFromEnd(linkedList, 10000);
		long remove10000ElementLinkedListEnd = (System.nanoTime() - mill) / 10000;

		System.out.println(
				"10.000 element removed from the end: " + remove10000ElementLinkedListEnd);

		// ============== 100.000 elements

		linkedList = new LinkedList<>();
		fillOutList(linkedList, 1_000_000);
		mill = System.nanoTime();
		addElementsToBeginning(linkedList, 100_000);
		long add1000000ElementLinkedListBeginning = (System.nanoTime() - mill) / 10000;

		System.out.println("100.000 element added into the beginning: "
				+ add1000000ElementLinkedListBeginning);

		// *Commented because method takes very-very long time 
//		linkedList = new LinkedList<>();
//		fillOutList(linkedList, 1_000_000);
//		mill = System.nanoTime();
//		addElementsToMiddle(linkedList, 100_000);
//		long add1000000ElementLinkedListMiddle = (System.nanoTime() - mill) / 10000;
//
//		System.out.println("100.000 element added into the middle: "
//				+ add1000000ElementLinkedListMiddle);

		linkedList = new LinkedList<>();
		fillOutList(linkedList, 1_000_000);
		mill = System.nanoTime();
		addElementsToEnd(linkedList, 100_000);
		long add10000000ElementLinkedListEnd = (System.nanoTime() - mill) / 10000;

		System.out.println(
				"100.000 element added into the end: " + add10000000ElementLinkedListEnd);

		linkedList = new LinkedList<>();
		fillOutList(linkedList, 1_000_000);
		mill = System.nanoTime();
		removeElementsFromBeginning(linkedList, 100_000);
		long remove1000000ElementLinkedListBeginning = (System.nanoTime() - mill) / 10000;

		System.out.println("100.000 element removed from the beginning: "
				+ remove1000000ElementLinkedListBeginning);

		// *Commented because method takes very-very long time 
//		linkedList = new LinkedList<>();
//		fillOutList(linkedList, 1_000_000);
//		mill = System.nanoTime();
//		removeElementsFromMiddle(linkedList, 100_000);
//		long remove10000000ElementLinkedListMiddle = (System.nanoTime() - mill) / 10000;
//
//		System.out.println("100.000 element removed from the middle: "
//				+ remove10000000ElementLinkedListMiddle);

		linkedList = new LinkedList<>();
		fillOutList(linkedList, 1_000_000);
		mill = System.nanoTime();
		removeElementsFromEnd(linkedList, 100_000);
		long remove1000000ElementLinkedListEnd = (System.nanoTime() - mill) / 10000;

		System.out.println("100.000 element removed from the end: "
				+ remove1000000ElementLinkedListEnd);

	}

	private static void fillOutList(List<Integer> list, int amountOfElements) {
		for (int i = 0; i < amountOfElements; i++) {
			list.add(i);
		}
	}

	public static void addElementsToBeginning(List<Integer> list,
			int numberOfElementsToAdd) {
		for (int i = 0; i < numberOfElementsToAdd; i++) {
			list.add(0, Integer.MAX_VALUE);
		}
	}

	public static void addElementsToMiddle(List<Integer> list,
			int numberOfElementsToAdd) {
		for (int i = 0; i < numberOfElementsToAdd; i++) {
			list.add(list.size() / 2, Integer.MAX_VALUE);
		}

	}

	public static void addElementsToEnd(List<Integer> list, int numberOfElementsToAdd) {
		for (int i = 0; i < numberOfElementsToAdd; i++) {
			list.add(Integer.MAX_VALUE);
		}
	}

	public static void removeElementsFromBeginning(List<Integer> list,
			int numberOfElementsToRemove) {
		for (int i = 0; i < numberOfElementsToRemove; i++) {
			list.remove(0);
		}
	}

	public static void removeElementsFromMiddle(List<Integer> list,
			int numberOfElementsToRemove) {
		for (int i = 0; i < numberOfElementsToRemove; i++) {
			list.remove(list.size() / 2);
		}
	}

	public static void removeElementsFromEnd(List<Integer> list,
			int numberOfElementsToRemove) {
		for (int i = 0; i < numberOfElementsToRemove; i++) {
			list.remove(list.size() - 1);
		}
	}

}
