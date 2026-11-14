package org.jcc;

public class CheckTwoStringHaveSameLength {
    public static void main(String[] args) {
        String str1 = "Hello World!";
        String str2 = "Programming is Good";

        if (str1.length() == str2.length()) {
            System.out.println("Two String Are Equal Length");
        } else {
            System.out.println("Two String Are Not Equal Length");
        }
    }
}
