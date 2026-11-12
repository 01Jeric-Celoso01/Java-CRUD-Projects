
package org.jcc;

import org.jcc.controller.BookController;
import org.jcc.controller.BorrowerController;
import org.jcc.controller.BorrowingController;

import org.jcc.implement.BookImplementation;
import org.jcc.implement.BorrowingImplement;

import org.jcc.service.BookService;
import org.jcc.service.BorrowingService;

import org.jcc.ui.Design;

import java.util.Scanner;

public class BookMain {

    public static void main(String[] args) {

        // IMPLEMENTATIONS
        BookImplementation bookImplementation = new BookImplementation();
        BorrowingImplement borrowingImplement = new BorrowingImplement();

        // SERVICES
        BookService bookService = new BookService(bookImplementation);
        BorrowingService borrowingService = new BorrowingService(borrowingImplement, bookImplementation);

        // INITIALIZE SAMPLE BORROWED COPIES
        borrowingService.initializeBorrowedCopies();

        // CONTROLLERS
        BookController bookController = new BookController(bookService);
        BorrowingController borrowingController = new BorrowingController(borrowingService);

        Scanner input = new Scanner(System.in);

        int choice = 0;

        while (true) {

            Design.newLine();
            Design.border();
            Design.title("LIBRARY MANAGEMENT SYSTEM");
            Design.border();

            Design.choices("0) EXIT FUNCTION      " + "1) BOOK MANAGEMENT      " + "2) BORROWER MANAGEMENT      " + "3) BORROWING MANAGEMENT      " + "4) VIEW ALL BORROWED BOOKS      " + "5) UPDATE BORROWING STATUS");

            Design.border();
            System.out.print("| CHOOSE A FUNCTION: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 0) {
                break;
            }

            else if (choice == 1) {

                while (true) {
                    Design.newLine();
                    Design.border();
                    Design.title("BOOK MANAGEMENT SYSTEM");
                    Design.border();

                    Design.choices("0) BACK TO MAIN MENU      " + "1) ADD NEW BOOK      " + "2) VIEW ALL BOOKS      " + "3) SEARCH BOOK BY ID      " + "4) UPDATE BOOK      " + "5) DELETE BOOK");

                    Design.border();
                    System.out.print("| CHOOSE A FUNCTION: ");
                    choice = input.nextInt();
                    input.nextLine();

                    if (choice == 0) {
                        break;
                    } else if (choice == 1) {
                        Design.newLine();
                        Design.border();
                        Design.title("ADD NEW BOOK");
                        Design.border();

                        bookController.createController();
                    } else if (choice == 2) {
                        Design.newLine();
                        Design.border();
                        Design.title("VIEW ALL BOOKS");
                        Design.border();

                        bookController.viewAllController();
                    } else if (choice == 3) {

                        Design.newLine();
                        Design.border();
                        Design.title("SEARCH BOOK BY ID");
                        Design.border();

                        bookController.searchBookById();
                    } else if (choice == 4) {

                        Design.newLine();
                        Design.border();
                        Design.title("UPDATE BOOK");
                        Design.border();

                        bookController.updateBookByTitle();
                    } else if (choice == 5) {
                        Design.newLine();
                        Design.border();
                        Design.title("DELETE BOOK");
                        Design.border();

                        bookController.deleteBookByTitle();
                    } else {

                        Design.border();
                        Design.status("INVALID CHOICE PLEASE TRY AGAIN");
                        Design.border();

                    }
                }
            } else if (choice == 2) {
                while (true) {
                    Design.newLine();
                    Design.border();
                    Design.title("BORROWER MANAGEMENT SYSTEM");
                    Design.border();

                    Design.choices("0) BACK TO MAIN MENU      " + "1) REGISTER NEW BORROWER      " + "2) VIEW ALL BORROWERS      " + "3) SEARCH BORROWER      " + "4) UPDATE BORROWER      " + "5) DELETE BORROWER");
                    Design.border();
                    System.out.print("| CHOOSE FUNCTION: ");
                    choice = input.nextInt();
                    input.nextLine();

                    if (choice == 0) {
                        break;
                    } else if (choice == 1) {
                        Design.newLine();
                        Design.border();
                        Design.title("REGISTER NEW BORROWER");
                        Design.border();

                        BorrowerController.registerBorrowerController();
                    } else if (choice == 2) {
                        Design.newLine();
                        Design.border();
                        Design.title("VIEW ALL BORROWERS");
                        Design.border();

                        BorrowerController.viewAllBorrowerController();
                    } else if (choice == 3) {
                        Design.newLine();
                        Design.border();
                        Design.title("SEARCH BORROWER BY ID");
                        Design.border();

                        BorrowerController.searchBorrowerById();
                    } else if (choice == 4) {
                        Design.newLine();
                        Design.border();
                        Design.title("UPDATE BORROWER BY ID");
                        Design.border();

                        BorrowerController.updateBorrowerById();
                    } else if (choice == 5) {
                        Design.newLine();
                        Design.border();
                        Design.title("DELETE BORROWER BY ID");
                        Design.border();

                        BorrowerController.deleteBorrowerById();
                    } else {

                        Design.status("INVALID CHOICE PLEASE TRY AGAIN");
                    }
                }
            } else if (choice == 3) {
                Design.newLine();
                Design.border();
                Design.title("BORROWING MANAGEMENT SYSTEM");
                Design.border();

                borrowingController.registerBorrowedController();
            } else if (choice == 4) {
                Design.newLine();
                Design.border();
                Design.title("VIEW ALL BORROWED BOOKS");
                Design.border();

                borrowingController.viewAllBorrowingsController();
            } else if (choice == 5) {
                Design.newLine();
                Design.border();
                Design.title("UPDATE BORROWING STATUS");
                Design.border();

                borrowingController.updateStatus();
            } else {
                Design.border();
                Design.status("INVALID CHOICE PLEASE TRY AGAIN");
                Design.border();

            }
        }
        Design.newLine();
        Design.status("THANK YOU FOR USING LIBRARY MANAGEMENT SYSTEM");
        input.close();
    }
}
