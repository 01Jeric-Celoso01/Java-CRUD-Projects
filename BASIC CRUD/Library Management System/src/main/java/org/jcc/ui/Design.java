package org.jcc.ui;

public class Design {
    ///
    public static void border() {
        System.out.print("|");
        for (int i = 1; i <= 162; i++) {
            System.out.print("+");
        }
        System.out.print("|");
        System.out.println();
    }


    ///
    public static void title(String mainTitle) {
        int totalSpace = 162;
        int remainingSpace = totalSpace - mainTitle.length();

        int leftSpace = remainingSpace / 2;
        int rightSpace = remainingSpace - leftSpace;

        System.out.print("|");
        for (int left = 1; left <= leftSpace; left++) {
            System.out.print(" ");
        }
        System.out.print(mainTitle);
        for (int right = 1; right <= rightSpace; right++) {
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.println();
    }

    public static void choices(String choiceFunction) {
        int totalSpace = 161;
        int remainingSpace = totalSpace - choiceFunction.length();

        System.out.print("| ");
        System.out.print(choiceFunction);
        for (int space = 1; space <= remainingSpace; space++) {
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.println();
    }

    public static void status(String status) {
        int totalSpace = 161;
        int remainingSpace = totalSpace - status.length();

        System.out.print("| ");
        System.out.print(status);
        for (int space = 1; space <= remainingSpace; space++) {
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.println();
    }

    public static void newLine() {
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
    }

}
