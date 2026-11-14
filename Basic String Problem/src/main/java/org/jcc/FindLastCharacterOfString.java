package org.jcc;

public class FindLastCharacterOfString {
    public static void main(String[] args) {
        String str = "Hello World!";

        char ch = str.charAt(str.length() - 1);

        System.out.println("Last Character: " + ch);
    }
}
