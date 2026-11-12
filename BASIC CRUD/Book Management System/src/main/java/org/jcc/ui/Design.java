package org.jcc.ui;

public class Design {
    public static void title(String title) {
        int spaces = 160;
        int remainingSpace = spaces - title.length();

        int leftSpace = remainingSpace / 2;
        int rightSpace = remainingSpace - leftSpace;

        System.out.print("|");
        for (int i = 1; i <= leftSpace; i++) {
            System.out.print(" ");
        }
        System.out.print(title);
        for (int i = 1; i <= rightSpace; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }

    public static void choices(String choice) {
        int spaces = 159;
        int remainingSpace = spaces - choice.length();

        System.out.print("| ");
        System.out.print(choice);
        for (int i = 1; i <= remainingSpace; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }

    public static void status(String status) {
        int spaces = 160;
        int length = spaces - status.length();

        System.out.print("| ");
        System.out.print(status);
        for (int i = 1; i < length; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }

    public static void border() {
        System.out.print("|");
        for (int i = 0; i < 160; i++) {
            System.out.print("+");
        }
        System.out.println("|");
    }
}
