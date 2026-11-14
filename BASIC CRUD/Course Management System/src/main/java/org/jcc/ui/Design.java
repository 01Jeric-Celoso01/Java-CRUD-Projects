package org.jcc.ui;

public class Design {
    static int length = 329;



    public static void title(String title) {
        int remainingSpace = length - title.length();

        int leftSpace = remainingSpace / 2;
        int rightSpace = remainingSpace - leftSpace;

        System.out.print("|||");
        for (int left = 1; left <= leftSpace; left++) {
            System.out.print(" ");
        }
        System.out.print(title);
        for(int right = 1; right <= rightSpace; right++) {
            System.out.print(" ");
        }
        System.out.println("|||");
    }

    public static void choices(String choices) {
        int remainingSpace = length - choices.length();

        System.out.print("||| ");
        System.out.print(choices);
        for (int space = 1; space < remainingSpace; space++) {
            System.out.print(" ");
        }
        System.out.println("|||");
    }


    public static void status(String choices) {
        int remainingSpace = length - choices.length();

        System.out.print("||| ");
        System.out.print(choices);
        for (int space = 1; space < remainingSpace; space++) {
            System.out.print(" ");
        }
        System.out.println("|||");
    }


    public static void addNewLine() {
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void border() {
        System.out.print("|||");
        for(int border = 1; border <= 329; border++) {
            System.out.print("+");
        }
        System.out.println("|||");
    }
}
