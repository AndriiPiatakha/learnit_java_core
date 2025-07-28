package com.itbulls.learnit.javacore.jcf.sequencedcollections;

import java.util.*;
import java.util.SequencedCollection;
import java.util.SequencedMap;

public class SequencedCollectionsDemo2 {

    public static void main(String[] args) {
        stackLikeBehaviorWithReversedList();
        simpleLRUCacheExample();
    }

    // === Example 1: Stack-like behavior using reversed() ===
    public static void stackLikeBehaviorWithReversedList() {
        System.out.println("\n=== Stack-like behavior with reversed() ===");

        // Create a fixed list of actions (simulating a command history)
        SequencedCollection<String> history = List.of("Open", "Edit", "Save");

        System.out.println("Normal order (oldest to newest): " + history);

        // reversed() gives a view from newest to oldest — similar to popping a stack
        SequencedCollection<String> reversed = history.reversed();
        System.out.println("Reversed (stack-like): " + reversed);

        // We can imagine calling 'undo' on the most recent actions this way
        System.out.println("Undoing last action: " + reversed.getFirst()); // would be "Save"
    }

    // === Example 2: LRU cache using SequencedMap ===
    public static void simpleLRUCacheExample() {
        System.out.println("\n=== Simple LRU Cache with SequencedMap ===");

        final int MAX_ENTRIES = 3;

        // LinkedHashMap in access-order mode, now seen as a SequencedMap
        SequencedMap<Integer, String> cache = new LinkedHashMap<>(16, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > MAX_ENTRIES;
            }
        };

        // Simulate access to data
        cache.put(1, "A"); // Cache: 1
        cache.put(2, "B"); // Cache: 1, 2
        cache.put(3, "C"); // Cache: 1, 2, 3
        cache.get(1);      // Access 1 → now most recently used → order: 2, 3, 1
        cache.put(4, "D"); // Triggers eviction of least recently used (2) → Cache: 3, 1, 4

        System.out.println("Current cache state (LRU order): " + cache);

        // Demonstrate access to edges
        System.out.println("Oldest entry: " + cache.firstEntry()); // Should be entry 3
        System.out.println("Most recent entry: " + cache.lastEntry()); // Should be entry 4
    }
}
