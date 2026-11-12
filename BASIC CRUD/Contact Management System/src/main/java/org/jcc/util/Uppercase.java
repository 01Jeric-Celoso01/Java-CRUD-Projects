package org.jcc.util;

public class Uppercase {
    public static String firstCharacter(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if ((i == 0) && ch >= 'a' && ch <= 'z') {
                result += (char) (ch - 32);
            } else {
                result += ch;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(firstCharacter("jhon"));
    }
}
