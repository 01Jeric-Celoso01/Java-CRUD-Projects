package org.jcc.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GenerateCurrentDate {
    public static String currentDate() {
        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        return currentDate.format(formatter);
    }

    public static void main(String[] args) {
        System.out.println(currentDate());
    }
}
