package org.jcc.util;

import java.util.Random;

public class GenerateStudentId {

    public static String generateStudentId() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 1; i <= 12; i++) {
            int number = random.nextInt(9);
            sb.append(number);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateStudentId());
    }
}
