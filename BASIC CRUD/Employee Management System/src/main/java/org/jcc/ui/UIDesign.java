package org.jcc.ui;

import java.util.Scanner;

public class UIDesign {
    public static void crossBorder() {
        System.out.print("||");
        for (int i = 1; i <= 163; i++) {
            System.out.print("+");
        }
        System.out.println("||");
    }

    public static void titleDesign(String title) {
        int totalSpace = 163;
        int remainingSpace = totalSpace - title.length();

        int leftSpace = remainingSpace / 2;
        int rightSpace = remainingSpace - leftSpace;

        System.out.print("||");
        for (int i = 1; i <= leftSpace; i++) {
            System.out.print(":");
        }

        System.out.print(title);

        for (int i = 1; i <= rightSpace; i++) {
            System.out.print(":");
        }
        System.out.println("||");
    }

    public static void choiceDesign(String choice) {
        int totalSpace = 162;
        int remainingSpace = totalSpace - choice.length();

        System.out.print("|| ");
        System.out.print(choice);
        for (int i = 1; i <= remainingSpace; i++) {
            System.out.print(" ");
        }
        System.out.print("||");
        System.out.println();
    }

    public static void statusDesign(String text) {
        int totalSpace = 162;
        int remainingSpace = totalSpace - text.length();

        System.out.print("|| ");
        System.out.print(text);
        for (int i = 1; i <= remainingSpace; i++) {
            System.out.print(" ");
        }
        System.out.print("||");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


    }
}
