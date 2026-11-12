package org.jcc.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GenerateAgeUsingBirthDay {

    public static long generateAge(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");

        LocalDate dateOfBirth = LocalDate.parse(birthDate, formatter);
        LocalDate now = LocalDate.now();

        return Period.between(dateOfBirth, now).getYears();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter birth date (MMddyyyy): ");
        String birthDate = input.nextLine();

        int age = Math.toIntExact(generateAge(birthDate));

        System.out.println("Age: " + age);

        input.close();
    }
}
