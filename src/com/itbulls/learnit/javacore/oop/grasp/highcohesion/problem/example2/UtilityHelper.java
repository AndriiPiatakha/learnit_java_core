package com.itbulls.learnit.javacore.oop.grasp.highcohesion.problem.example2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

// Problem example:
// "Utility" class with unrelated static methods, low cohesion.

public class UtilityHelper {

    // Date formatting
    public static String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ISO_DATE);
    }

    // Random password generation
    public static String generateRandomPassword(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    // Email validation
    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    // String trimming and normalization
    public static String normalizeWhitespace(String input) {
        if (input == null) {
            return "";
        }
        return input.trim().replaceAll("\\s+", " ");
    }

    // Simple math helper
    public static double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}