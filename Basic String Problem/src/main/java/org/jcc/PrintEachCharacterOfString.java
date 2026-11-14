package org.jcc;

public class PrintEachCharacterOfString {
    public static void main(String[] args) {
        String str = "Hello World!";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            System.out.println(ch);
        }
    }
}
