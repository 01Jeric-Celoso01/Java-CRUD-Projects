package org.jcc.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class GenerateAge {
    public static long age(String birthDay) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");

        LocalDate date = LocalDate.parse(birthDay, formatter);
        LocalDate now = LocalDate.now();

        return Period.between(date, now).getYears();
    }
}
