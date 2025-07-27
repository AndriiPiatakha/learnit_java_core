package com.itbulls.learnit.javacore.javaupdates;

public class Java21PatternMatching {
	// ---------- Records & sealed hierarchy for demos ----------
    sealed interface Shape permits Circle, Rectangle {}
    record Circle(double r) implements Shape {}
    record Rectangle(double w, double h) implements Shape {}

    /** Nested record for showing deconstruction inside a record pattern */
    record Box(String label, Shape shape) {}
    
 // ---------- Enum for demo ----------
    enum Day { MON, TUE, WED }

    public static void main(String[] args) {
        System.out.println("=== Traditional switch limitations ===");
        traditionalSwitch(2);

        System.out.println("\n=== instanceof pattern matching ===");
        instanceofDemo("Hello");
        instanceofDemo(42);

        System.out.println("\n=== Modern switch: type patterns, null & when-guard ===");
        modernSwitch(null);
        modernSwitch("Java");
        modernSwitch(7);

        System.out.println("\n=== Record patterns & nested patterns ===");
        recordPatternDemo(new Box("Gift", new Circle(3)));
        recordPatternDemo(new Box("Package", new Rectangle(2, 4)));

        System.out.println("\n=== Exhaustive switch over sealed hierarchy ===");
        describeShape(new Circle(5));
        describeShape(new Rectangle(3, 6));
        
        System.out.println("\n=== Exhaustive switch over enum ===");
        printDayType(Day.TUE);
        
        System.out.println("\n=== Comma-separated patterns ===");
        multiLabelPattern(null);
    }

    // ─────────────────────────────────────────────────────────────
    // 1. Traditional switch could only handle primitives, String, enum
    private static void traditionalSwitch(int code) {
        switch (code) {
            case 1: System.out.println("ONE");
            case 2: System.out.println("TWO");
            default: System.out.println("OTHER");
        }
        // Limitations: no null, no Object, no pattern logic.
    }

    // 2. instanceof pattern matching (Java 16+)
    private static void instanceofDemo(Object obj) {
//    	// before Java 16
//    	if (obj instanceof String) {
//    	    String s = (String) obj;
//    	    // use s
//    	}
    	
    	
        if (obj instanceof String s) {
            System.out.println("Upper-case string: " + s.toUpperCase());
        } else if (obj instanceof Integer i && i % 2 == 0) {
            System.out.println("Even integer: " + i);
        } else {
            System.out.println("Something else: " + obj);
        }
        
    }

    // 3. switch with type patterns, null handling, and when-guards
    private static void modernSwitch(Object o) {
        String result = switch (o) {
            case null                 -> "It is null!";
            case String s             -> "String length = " + s.length();
            case Integer i when i > 0 -> "Positive integer " + i;
            case Integer i            -> "Non-positive integer " + i;
            default                   -> "Unknown type: " + o;
        };
        System.out.println(result);
    }

    // 4 & 5. Record patterns and nested patterns inside switch
    private static void recordPatternDemo(Box box) {
        String msg = switch (box) {
            // deconstruct Box and its inner Shape in one shot
            case Box(String label, Circle(double r)) ->
                    "Box \"" + label + "\" contains a circle of radius " + r;
            case Box(String label, Rectangle(double w, double h)) ->
                    "Box \"" + label + "\" contains a rectangle " + w + "×" + h;
        };
        System.out.println(msg);
    }

    // 6. Exhaustiveness with sealed types (no default needed)
    private static void describeShape(Shape s) {
        String desc = switch (s) {
            case Circle c    -> "Circle with r=" + c.r();
            case Rectangle r -> "Rectangle " + r.w() + "×" + r.h();
        };
        System.out.println(desc);
    }
    
    private static void printDayType(Day day) {
        String result = switch (day) {
            case MON -> "Start of week";
            case TUE -> "Second day";
            case WED -> "Midweek";
        };
        System.out.println(result);
    }
    
    // 7. Comma-separated patterns
    private static void multiLabelPattern(Object obj) {
        String result = switch (obj) {
            case String s -> "It's some kind of text: " + s;
            case Integer i                -> "It's a number: " + i;
            case null, default -> "Default value";
        };
        System.out.println(result); 
    }

    // ────────────────── Common mistakes (compile-time errors) ──────────────────
    /*
    // (A) Incompatible patterns in the same switch label
    switch (obj) {
        // Cannot mix unrelated types in one comma-separated label
        case String s, Integer i -> …
    }

    // (B) Duplicate dominated pattern
    switch (obj) {
        case Object o  -> …  // dominates everything that follows
        case String s  -> …  // unreachable – compiler error
    }
    */
}