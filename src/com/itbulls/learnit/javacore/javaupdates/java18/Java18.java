package com.itbulls.learnit.javacore.javaupdates.java18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Example usage:
 * <pre>
 *   MyClass m = new MyClass();
 *   m.doSomething();
 * </pre>
 */
public class Java18 {
	
	/**
	 * Demonstrates UTF-8 file writing and reading in Java 18+.
	 *
	 * <p>Example usage:
	 * {@snippet :
	 *   Path file = Path.of("utf8-demo.txt");
	 *   List<String> lines = List.of("Hello", "Привет", "你好");
	 *   Files.write(file, lines);
	 *   List<String> result = Files.readAllLines(file);
	 *   result.forEach(System.out::println);
	 * }
	 * 
	 */
	public static void main(String[] args) throws IOException {
		Path file = Path.of("utf8-demo.txt");

        // ✅ Step 1: Write non-ASCII content (no charset specified)
        List<String> linesToWrite = List.of(
                "Hello world",
                "Привет мир",       // Russian
                "你好，世界",         // Chinese
                "¡Hola mundo!",     // Spanish
                "Grüß Gott"         // German with ü
        );
        Files.write(file, linesToWrite);  // UTF-8 is used automatically in Java 18+

        System.out.println("✅ File written with UTF-8 content");

        // ✅ Step 2: Read the content back
        List<String> readLines = Files.readAllLines(file); // UTF-8 is assumed
        System.out.println("\n📖 File contents:");
        readLines.forEach(System.out::println);
    }

}
