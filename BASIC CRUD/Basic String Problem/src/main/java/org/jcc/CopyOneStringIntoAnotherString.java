package org.jcc;

public class CopyOneStringIntoAnotherString {
    public static void main(String[] args) {
        String str = "Hello World!";
        String copyString = "";

        for (int i = 0; i < str.length(); i++) {
            copyString += str.charAt(i);
        }

        System.out.println("Original: " + str);
        System.out.println("Copy: " + copyString);
    }
}
