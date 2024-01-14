package com.itbulls.learnit.javacore.javaupdates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.CompactNumberFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Java12 {
	
	public static void main(String[] args) {
		System.out.println("===== CompactNumberFormat =====");
		// Create a CompactNumberFormat for the default locale
        NumberFormat compactNumberFormat = CompactNumberFormat.getCompactNumberInstance();

        // Format a number using compact format
        double number = 1500.5;
        String compactNumber = compactNumberFormat.format(number);
        System.out.println("Compact Format: " + compactNumber);

        // Format the same number using regular number format
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        String regularNumber = numberFormat.format(number);
        System.out.println("Regular Format: " + regularNumber);

        // Create a CompactNumberFormat for a specific locale (US in this case)
        NumberFormat compactNumberFormatUs = CompactNumberFormat
        		.getCompactNumberInstance(Locale.US, CompactNumberFormat.Style.LONG);

        // Format a number using compact format with US locale
        String compactNumberUs = compactNumberFormatUs.format(number);
        System.out.println("Compact Format (US): " + compactNumberUs);
        
        System.out.println();
        System.out.println("===== Demo of 'indent' method from String class =====");
        String originalString = "Hello\nWorld";
        
        // Adding 3 leading spaces to each line
        String indentedString = originalString.indent(3);
        
        System.out.println("Original String:\n" + originalString);
        System.out.println("Indented String:\n" + indentedString);
        
        System.out.println();
        System.out.println("===== Demo of 'transform' method from String class =====");
        
        // Transform each String to number (amount of characters in a word)
        String transformedString = originalString.transform(s -> Integer.toString(s.length()));
        
        // Transforming each character to uppercase
        String transformedString2 = originalString.transform(String::toUpperCase);
        
        System.out.println("Original String: " + originalString);
        System.out.println("Transformed String #1: " + transformedString);
        System.out.println("Transformed String #2: " + transformedString2);
        
        
        System.out.println();
        System.out.println("===== Files.mismatch(path1, path2) =====");
        Path path1 = Paths.get("test_text.txt");
        Path path2 = Paths.get("README.md");

        try {
            long mismatchPosition = Files.mismatch(path1, path2);

            if (mismatchPosition == -1) {
                System.out.println("Files are identical, no mismatch.");
            } else {
                System.out.println("Files differ at position: " + mismatchPosition);
            }
        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
        
        
        System.out.println();
        System.out.println("===== Teeing Collector =====");
        List<Integer> numbers = List.of(5, 3, 8, 1, 7, 2, 4, 6);

        Result result = numbers.stream()
                .collect(Collectors.teeing(
                        Collectors.minBy(Integer::compareTo),
                        Collectors.maxBy(Integer::compareTo),
                        (min, max) -> new Result(min.orElse(null), max.orElse(null))
                ));

        System.out.println("Minimum value: " + result.getMin());
        System.out.println("Maximum value: " + result.getMax());
        
	}
	
	
	 static class Result {
	        private final Integer min;
	        private final Integer max;

	        public Result(Integer min, Integer max) {
	            this.min = min;
	            this.max = max;
	        }

	        public Integer getMin() {
	            return min;
	        }

	        public Integer getMax() {
	            return max;
	        }
	    }

}
