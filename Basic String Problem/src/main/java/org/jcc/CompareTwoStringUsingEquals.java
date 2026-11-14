package org.jcc;

public class CompareTwoStringUsingEquals {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";

        if (str1.equals(str2)) {
            System.out.println("Two String Are Equal");
        } else {
            System.out.println("Two String Are Not Equal");
        }
    }
}
