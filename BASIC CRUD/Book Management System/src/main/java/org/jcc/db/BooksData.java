package org.jcc.db;

import org.jcc.enums.Category;
import org.jcc.model.Books;

import java.util.ArrayList;
import java.util.List;

public class BooksData {
    public static List<Books> bookLists() {
        List<Books> books = new ArrayList<>();

        Books b1 = new Books("BK001", "Clean Code", "Robert C. Martin", "Prentice Hall", "9780132350884", 2008, 5, Category.TECHNOLOGY);
        books.add(b1);

        Books b2 = new Books("BK002", "Effective Java", "Joshua Bloch", "Addison-Wesly", "9780134685991", 2018, 3, Category.TECHNOLOGY);
        books.add(b2);

        Books b3 = new Books("BK003", "The Great Gatsby", "F. Scott Fitzgerald", "Scribner", "9780743273565", 1925, 7, Category.FICTION);
        books.add(b3);

        Books b4 = new Books("BK004", "A Brief History of Time", "Stephin Hawking", "Bantam Books", "9780553380163", 1988, 4, Category.SCIENCE);
        books.add(b4);

        Books b5 = new Books("BK005", "The Art of Mathematics", "Jerry P. King", "Dover Publications", "9780486450367", 2006, 6, Category.MATHEMATICS);
        books.add(b5);

        return books;
    }
}
