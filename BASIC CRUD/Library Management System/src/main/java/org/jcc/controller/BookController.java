
package org.jcc.controller;

import org.jcc.model.BookModel;
import org.jcc.enums.BookCategory;
import org.jcc.service.BookService;
import org.jcc.ui.Design;
import org.jcc.util.GenerateId;

import java.util.List;
import java.util.Scanner;

public class BookController {

    private final Scanner input = new Scanner(System.in);
    private final BookService bookService;

    // CONSTRUCTOR INJECTION
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // CREATE BOOK
    public void createController() {
        String id = GenerateId.generateBookId();

        System.out.print("| TITLE: ");
        String title = input.nextLine();

        System.out.print("| AUTHOR: ");
        String author = input.nextLine();

        System.out.print("| ISBN: ");
        String isbn = input.nextLine();

        System.out.print("| PUBLISHER: ");
        String publisher = input.nextLine();

        System.out.print("| CATEGORY: ");
        BookCategory category = BookCategory.valueOf(input.nextLine().toUpperCase());

        System.out.print("| PUBLICATION YEAR: ");
        int publicationYear = Integer.parseInt(input.nextLine());

        System.out.print("| QUANTITY: ");
        int quantity = Integer.parseInt(input.nextLine());

        BookModel book = new BookModel(id, title, author, isbn, publisher, category, publicationYear, quantity, quantity);

        bookService.createBooks(book);

        Design.border();
        Design.status("BOOK SUCCESSFULLY CREATED!");
        Design.border();
    }

    // VIEW ALL BOOKS
    public void viewAllController() {
        List<BookModel> books = bookService.viewAllBooks();

        if (books.isEmpty()) {
            Design.status("NO BOOKS AVAILABLE!");
            return;
        }

        System.out.printf("| %-10s | %-27s | %-27s | %-13s | %-25s | %-12s | %-4s | %-8s | %-10s |\n", "BOOKD ID", "BOOK TITLE", "AUTHOR", "ISBN", "PUBLISHER", "CATEGORY", "YEAR", "QUANTITY", "AVAILABLE");
        Design.border();
        for (BookModel book : books) {
            System.out.printf("| %-10s | %-27s | %-27s | %-13s | %-25s | %-12s | %-3s | %-8s | %-10s |\n",
                    book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublisher(), book.getCategory(), book.getPublicationYear(), book.getQuantity(), book.getAvailableCopies());
        }
        Design.border();
    }

    // SEARCH BOOK BY ID
    public void searchBookById() {
        System.out.print("| ENTER BOOK ID: ");
        String id = input.nextLine();

        BookModel book = bookService.searchById(id);

        if (book == null) {
            Design.status("BOOK NOT FOUND!");
            return;
        }

        Design.border();
        System.out.printf("| BOOK ID: %-151s |\n", book.getId());
        System.out.printf("| TITLE: %-153s |\n", book.getTitle());
        System.out.printf("| AUTHOR: %-152s |\n", book.getAuthor());
        System.out.printf("| ISBN: %-154s |\n", book.getIsbn());
        System.out.printf("| PUBLISHER: %-149s |\n", book.getPublisher());
        System.out.printf("| CATEGORY: %-150s |\n", book.getCategory());
        System.out.printf("| PUBLICATION YEAR: %-142s |\n", book.getPublicationYear());
        System.out.printf("| QUANTITY: %-150s |\n", book.getQuantity());
        System.out.printf("| AVAILABLE COPIES: %-142s |\n", book.getAvailableCopies());
        Design.border();
    }

    // UPDATE BOOK BY TITLE
    public void updateBookByTitle() {

        System.out.print("| ENTER BOOK TITLE: ");
        String title = input.nextLine();

        BookModel book = bookService.updateByTitle(title);

        if (book == null) {
            Design.status("BOOK NOT FOUND!");
            return;
        }

        System.out.println("| BOOK FOUND: " + book.getTitle());

        System.out.print("| NEW TITLE: ");
        book.setTitle(input.nextLine());

        System.out.print("| NEW AUTHOR: ");
        book.setAuthor(input.nextLine());

        System.out.print("| NEW ISBN: ");
        book.setIsbn(input.nextLine());

        System.out.print("| NEW PUBLISHER: ");
        book.setPublisher(input.nextLine());

        System.out.print("| NEW CATEGORY: ");
        book.setCategory(
                BookCategory.valueOf(input.nextLine().toUpperCase())
        );

        System.out.print("| NEW PUBLICATION YEAR: ");
        book.setPublicationYear(Integer.parseInt(input.nextLine()));

        System.out.println("| BOOK SUCCESSFULLY UPDATED!");
    }


    // DELETE BOOK BY TITLE
    public void deleteBookByTitle() {

        System.out.print("| ENTER BOOK TITLE: ");
        String title = input.nextLine();

        BookModel book = bookService.deleteByTitle(title);

        if (book == null) {
            Design.status("BOOK NOT FOUND!");
            return;
        }

        Design.status("BOOK SUCCESSFULLY DELETED!");
    }
}
