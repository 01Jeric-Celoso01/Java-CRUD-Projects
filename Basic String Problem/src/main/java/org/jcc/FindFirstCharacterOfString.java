package org.jcc;

public class FindFirstCharacterOfString {
    public static void main(String[] args) {
        String str = "Hello World!";

        if (str.length() > 0) {

            char ch = str.charAt(0);

            System.out.println("First Character: " + ch);
        } else {
            System.out.println("The String Is Empty");
        }
    }
}
