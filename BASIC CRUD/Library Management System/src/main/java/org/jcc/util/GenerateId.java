package org.jcc.util;

public class GenerateId {

    private static int bookCounter = 0;
    private static int borrowerCounter = 0;
    private static int borrowingCounter = 0;

    public static String generateBookId() {
        bookCounter++;

        return String.format("BK%08d", bookCounter);
    }

    public static String generateBorrowerId() {
        borrowerCounter++;

        return String.format("BR%08d", borrowerCounter);
    }

    public static String generateBorrowingId() {
        borrowingCounter++;

        return String.format("BG%08d", borrowingCounter);
    }
}
