package com.itbulls.learnit.javacore.oop.grasp.highcohesion.solution.example2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormattingService {

    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

    public String formatDate(LocalDate date) {
        return date.format(formatter);
    }
}
