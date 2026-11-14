package org.jcc;

public class CheckWetherIfStringEmpty {
    public static void main(String[] args) {
        String str = "Hello World!";

        if (str.length() == 0) {
            System.out.println("The String Is Empty");
        } else {
            System.out.println("The String Is Not Empty");
        }
    }
}
