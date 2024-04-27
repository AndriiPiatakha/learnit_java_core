package com.itbulls.learnit.javacore.cleancode.checkstyle;

import java.util.*;

public class CheckstyleDemoBefore {

    public final int calculateSum(int a, int b) {
        return a + b;
    }

    public int calculateDifference(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
    	CheckstyleDemoBefore demo = new CheckstyleDemoBefore();

        int a = 10;
        int b = 5;

        System.out.println("Sum: " + demo.calculateSum(a, b));
        System.out.println("Difference: " + demo.calculateDifference(a, b));
    }
}
