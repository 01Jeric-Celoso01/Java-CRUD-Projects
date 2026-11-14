package org.jcc;

public class CountNumberInString {
    public static void main(String[] args) {
        String str = "1 L0v3 Pr0gr4mm1ng";
        int counter = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= '0' && ch <= '9') {
                counter++;
            }
        }

        System.out.println("Total Number In String: " + counter);
    }
}
