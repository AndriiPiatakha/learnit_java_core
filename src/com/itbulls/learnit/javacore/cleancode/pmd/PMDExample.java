package com.itbulls.learnit.javacore.cleancode.pmd;

import java.util.*;

public class PMDExample {

    private int age;
    private String name;

    public PMDExample(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public void setName(String newName) {
        name = newName;
    }

    public static void main(String[] args) {
        PMDExample example = new PMDExample(25, "John");
        example.displayInfo();

        String[] colors = {"red", "green", "blue"};
        for (int i = 0; i <= colors.length; i++) { // Array index out of bounds
            System.out.println("Color: " + colors[i]);
        }

        int x = 10;
        if (x == 10);

        int y = 20;
        int result = x + y; // Unused variable 'result'
    }
}
