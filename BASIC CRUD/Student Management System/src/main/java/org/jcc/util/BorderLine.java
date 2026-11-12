package org.jcc.util;

public class BorderLine {
    public static void borderLine() {
        System.out.print("||");
        for(int i = 1; i <= 112; i++) {
            System.out.print("=");
        }
        System.out.println("||");
    }

    public static void displayChoice(String menu, int firstSpace) {
        String result = "";

        for (int i = 1; i <= firstSpace; i++) {
            result += " ";
        }

        System.out.println("|| " + menu + result + " ||");
    }

    public static void titleMenu(String title) {
        System.out.printf("|| %-15s %-38s %-15s %-39s || \n", " ", title, " ", title);
    }

    public static void displayFeedback(String feedback) {
        System.out.printf("|| %-50s %-59s || \n", feedback, " ");
    }

    public static void main(String[] args) {
        borderLine();
        displayFeedback("Invalid Choice");
    }
}
