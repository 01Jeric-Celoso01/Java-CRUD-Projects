package org.jcc.util;

public class GenerateId {
    static int counter;

    public static String contactId() {
        counter++;

        return String.format("%06d", counter);
    }
}
