package org.jcc.ui;

public class Design {
    static int spaces = 160;


    public static void title(String title) {
        int remainingSpace = spaces - title.length();

        int leftSpace = remainingSpace / 2;
        int rightSpace = remainingSpace - leftSpace;

        System.out.print("|");
        for (int left = 1; left <= leftSpace; left++) {
            System.out.print(" ");
        }

        System.out.print(title);

        for (int right = 1; right <= rightSpace; right++) {
            System.out.print(" ");
        }

        System.out.println("|");
    }

    public static void choices(String choice) {
        int remainingSpace = spaces - choice.length();

        System.out.print("| ");
        System.out.print(choice);
        for (int i = 1; i < remainingSpace; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }

    public static void status(String choice) {
        int remainingSpace = spaces - choice.length();

        System.out.print("| ");
        System.out.print(choice);
        for (int i = 1; i < remainingSpace; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }

    public static void border() {
        System.out.print("|");
        for (int i = 1; i <= spaces; i++) {
            System.out.print("+");
        }
        System.out.println("|");
    }

    public static void newLine() {
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
