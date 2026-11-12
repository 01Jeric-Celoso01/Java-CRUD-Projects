package org.jcc.util;

public class GenerateEmployeeID {

    private static int counter = 0;

    public static String generateEmployeeId() {

        counter++;

        return String.format("%08d", counter);
    }
}
