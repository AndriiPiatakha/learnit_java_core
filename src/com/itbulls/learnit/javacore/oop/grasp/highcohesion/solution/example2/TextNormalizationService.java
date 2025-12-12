package com.itbulls.learnit.javacore.oop.grasp.highcohesion.solution.example2;

public class TextNormalizationService {

    public String normalizeWhitespace(String input) {
        if (input == null) {
            return "";
        }
        return input.trim().replaceAll("\\s+", " ");
    }
}