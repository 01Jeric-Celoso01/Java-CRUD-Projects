package org.jcc;

import org.jcc.controller.BooksController;
import org.jcc.implement.BooksImplement;
import org.jcc.service.BooksService;
import org.jcc.ui.Design;

import java.util.Scanner;

public class MainSystem {
    public static void main() {

        BooksImplement booksImplement = new BooksImplement();
        BooksService booksService = new BooksService(booksImplement);
        BooksController booksController = new BooksController(booksService);

        Scanner input = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n");
            Design.border();
            Design.title("BOOK MANAGEMENT SYSTEM");
            Design.border();
            Design.choices("0) EXIT FUNCTION   1) REGISTER BOOKS   2) VIEW ALL BOOKS   3) UPDATE BOOK INFORMATION   4) REMOVE BOOK" +
                    "");
            Design.border();
            System.out.print("| FUNCTION: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 0) {
                System.out.println();
                Design.border();
                Design.status("EXIT SYSTEM");
                Design.border();
                break;
            } else if (choice == 1) {
                System.out.println("\n");
                Design.border();
                Design.title("REGISTER BOOK");
                Design.border();
                booksController.registerController();
                Design.border();
            } else if (choice == 2) {
                System.out.println("\n");
                Design.border();
                Design.title("LIST OF BOOKS");
                Design.border();
                booksController.viewAllController();
                Design.border();
            } else if (choice == 3) {
                System.out.println("\n");
                Design.border();
                Design.title("LIST OF BOOKS");
                Design.border();
                booksController.updateController();
                Design.border();
            } else if(choice == 4) {
                System.out.println("\n");
                Design.border();
                Design.title("REMOVE BOOK");
                Design.border();
                booksController.deleteController();
                Design.border();
            } else {
                Design.status("INVALID CHOICE PLEASE TRY AGAIN");
            }
        }
    }
}
