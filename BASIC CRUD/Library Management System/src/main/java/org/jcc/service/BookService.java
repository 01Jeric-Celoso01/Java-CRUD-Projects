package org.jcc.service;

import org.jcc.implement.BookImplementation;
import org.jcc.model.BookModel;

import java.util.List;

public class BookService {

    private final BookImplementation bookImplementation;

    public BookService(BookImplementation bookImplementation) {
        this.bookImplementation = bookImplementation;
    }

    public BookModel createBooks(BookModel book) {
        return bookImplementation.create(book);
    }

    public List<BookModel> viewAllBooks() {
        return bookImplementation.view();
    }

//    public BookModel searchByTitle(String title) {
//        return bookImplementation.search(title);
//    }

    public BookModel searchById(String id) {
        return bookImplementation.findById(id);
    }

    public BookModel updateByTitle(String title) {
        return bookImplementation.update(title);
    }

    public BookModel deleteByTitle(String title) {
        return bookImplementation.delete(title);
    }
}