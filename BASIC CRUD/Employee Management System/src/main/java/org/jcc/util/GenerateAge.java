package org.jcc.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class GenerateAge {
    public static long generateAge(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");

        LocalDate dateOfBirth = LocalDate.parse(birthDate, formatter);
        LocalDate now = LocalDate.now();

        return Period.between(dateOfBirth, now).getYears();
    }

    public static void main() {
        System.out.println(generateAge("03011999"));
    }
}
