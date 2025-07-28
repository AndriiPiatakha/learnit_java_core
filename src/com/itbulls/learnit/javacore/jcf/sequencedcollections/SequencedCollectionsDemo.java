package com.itbulls.learnit.javacore.jcf.sequencedcollections;

import java.util.*;
import java.util.SequencedCollection;
import java.util.SequencedMap;
import java.util.SequencedSet;

public class SequencedCollectionsDemo {

    public static void main(String[] args) {
        demoWithListBeforeJEP431();
        demoWithListAfterJEP431();

        demoWithLinkedHashMapBeforeJEP431();
        demoWithSequencedMapAfterJEP431();

        demoWithSetReversal();
    }

    // === BEFORE JEP 431: working with List and order ===
    public static void demoWithListBeforeJEP431() {
        System.out.println("\n--- List BEFORE JEP 431 ---");

        List<String> list = new LinkedList<>();
        list.add("B");
        list.add(0, "A"); // Add to beginning
        list.add("C");

        System.out.println("First element: " + list.get(0));
        System.out.println("Last element: " + list.get(list.size() - 1));

        // Reverse manually
        List<String> reversed = new ArrayList<>(list);
        Collections.reverse(reversed);
        System.out.println("Reversed list: " + reversed);
    }

    // === AFTER JEP 431: cleaner access with SequencedCollection ===
    public static void demoWithListAfterJEP431() {
        System.out.println("\n--- List AFTER JEP 431 (SequencedCollection) ---");

        SequencedCollection<String> list = new LinkedList<>();
        list.addFirst("A");
        list.addLast("B");
        list.addLast("C");

        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());

        SequencedCollection<String> reversed = list.reversed();
        System.out.println("Reversed view: " + reversed);
    }

    // === BEFORE JEP 431: Getting first/last from LinkedHashMap manually ===
    public static void demoWithLinkedHashMapBeforeJEP431() {
        System.out.println("\n--- LinkedHashMap BEFORE JEP 431 ---");

        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        // Get first entry manually
        Map.Entry<Integer, String> firstEntry = map.entrySet().iterator().next();
        System.out.println("First entry: " + firstEntry);

        // Get last entry manually — not trivial!
        Map.Entry<Integer, String> lastEntry = null;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            lastEntry = entry;
        }
        System.out.println("Last entry: " + lastEntry);
    }

    // === AFTER JEP 431: cleaner with SequencedMap ===
    public static void demoWithSequencedMapAfterJEP431() {
        System.out.println("\n--- LinkedHashMap AFTER JEP 431 (SequencedMap) ---");

        SequencedMap<Integer, String> map = new LinkedHashMap<>();
        map.putFirst(1, "one");
        map.putLast(2, "two");
        map.putLast(3, "three");

        System.out.println("First entry: " + map.firstEntry());
        System.out.println("Last entry: " + map.lastEntry());

        SequencedMap<Integer, String> reversed = map.reversed();
        System.out.println("Reversed map (view): " + reversed);
    }

    // === Working with SequencedSet ===
    public static void demoWithSetReversal() {
        System.out.println("\n--- SequencedSet example ---");

        SequencedSet<String> set = new LinkedHashSet<>();
        set.addFirst("first");
        set.addLast("middle");
        set.addLast("last");

        System.out.println("Set in order: " + set);
        System.out.println("First: " + set.getFirst());
        System.out.println("Last: " + set.getLast());
        System.out.println("Reversed: " + set.reversed());
    }
}
