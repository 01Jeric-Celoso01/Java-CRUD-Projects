package org.jcc.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GenerateDate {
    public static String currentDate() {
        LocalDate current = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        return current.format(formatter);
    }

    public static void main(String[] args) {
        System.out.println(currentDate());
    }
}
