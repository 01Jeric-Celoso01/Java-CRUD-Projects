package org.jcc.controller;

import org.jcc.enums.Category;
import org.jcc.model.Books;
import org.jcc.service.BooksService;
import org.jcc.ui.Design;

import java.util.List;
import java.util.Scanner;

public class BooksController {
    private BooksService service;

    public BooksController(BooksService service) {
        this.service = service;
    }

    static Scanner input = new Scanner(System.in);

    public void registerController() {
        System.out.print("| ID        : ");
        String id = input.nextLine();

        System.out.print("| TITLE     : ");
        String title = input.nextLine();

        System.out.print("| AUTHOR    : ");
        String author = input.nextLine();

        System.out.print("| PUBLISHER : ");
        String publisher = input.nextLine();

        System.out.print("| ISBN      : ");
        String isbn = input.nextLine();

        System.out.print("| YEAR      : ");
        int year = input.nextInt();

        System.out.print("| QUANTITY  : ");
        int quantity = input.nextInt();

        Design.choices("1) FICTION   2) NON_FICTION   3) SCIENCE   4) TECHNOLOGY   5) HISTORY  6) MATHEMATICS");
        Design.choices("7) BIOGRAPHY   8) EDUCATION   9) ROMANCE   10) FANTASY   11) MYSTERY   12)OTHER");
        System.out.print("| CATEGORY  : ");
        int category = input.nextInt();

        Category categories = null;
        categories = Category.values()[category - 1];

        Books b = new Books(id, title, author, publisher, isbn, year, quantity, categories);
        service.registerService(b);
    }

    public void viewAllController() {
        List<Books> books = service.viewService();

        System.out.printf("| %-6s | %-36s| %-27s | %-33s | %-13s | %-4s | %-2s | %-11s |\n", "ID", "TITLE", "AUTHOR", "PUBLISHER", "ISBN", "YEAR", "QUANTITY", "CATEGORY");
        Design.border();
        for (Books b : books) {
            System.out.printf("| %-6s | %-36s| %-27s | %-33s | %-13s | %-4s | %-8s | %-11s |\n", b.getId(), b.getTitle(), b.getAuthor(), b.getPublisher(), b.getIsbn(), b.getYear(), b.getQuantity(), b.getCategory());
        }
    }

    public void updateController() {
        System.out.print("| ID        : ");
        String id = input.nextLine();

        Books b = service.updateService(id);

        if (b.getId().equals(id)) {
            Design.border();
            Design.choices("1) TITLE     2) AUTHOR     3) PUBLISHER     4) ISBN     5) YEAR     6) QUANTITY     7) CATEGORY");
            Design.border();
            System.out.print("| CHOOSE    : ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("| TITLE     : ");
                    b.setTitle(input.nextLine());
                    break;
                case 2:
                    System.out.print("| AUTHOR    : ");
                    b.setAuthor(input.nextLine());
                    break;
                case 3:
                    System.out.print("| PUBLISHER : ");
                    b.setPublisher(input.nextLine());
                    break;
                case 4:
                    System.out.print("| ISBN      : ");
                    b.setIsbn(input.nextLine());
                    break;
                case 5:
                    System.out.print("| YEAR      : ");
                    b.setYear(input.nextInt());
                    break;
                case 6:
                    System.out.print("| QUANTITY  : ");
                    b.setQuantity(input.nextInt());
                    break;
                case 7:
                    Design.choices("1) FICTION   2) NON_FICTION   3) SCIENCE   4) TECHNOLOGY   5) HISTORY  6) MATHEMATICS");
                    Design.choices("7) BIOGRAPHY   8) EDUCATION   9) ROMANCE   10) FANTASY   11) MYSTERY   12)OTHER");
                    System.out.print("| CATEGORY  : ");
                    int category = input.nextInt();

                    Category categories = null;
                    categories = Category.values()[category - 1];

                    b.setCategory(categories);

                    break;
                default:
                    break;
            }
        } else {
            Design.status(id + " ID NOT FOUND");
        }
    }

    public void deleteController() {
        System.out.print("ID: ");
        String id = input.nextLine();

        Books b = service.deleteService(id);

    }
}
