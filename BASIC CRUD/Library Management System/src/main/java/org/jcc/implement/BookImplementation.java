package org.jcc.implement;

import org.jcc.data.SampleBooks;
import org.jcc.model.BookModel;
import org.jcc.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookImplementation implements BookRepository {

    private final List<BookModel> BOOKS = new ArrayList<>(SampleBooks.sampleBooks());

    @Override
    public BookModel create(BookModel book) {
        if (book == null) {
            return null;
        }

        BOOKS.add(book);
        return book;
    }

    @Override
    public List<BookModel> view() {
        return BOOKS;
    }

    // SEARCH BY TITLE
    @Override
    public BookModel search(String title) {
        if (title == null || title.isBlank()) {
            return null;
        }

        for (BookModel book : BOOKS) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // SEARCH BY ID
    @Override
    public BookModel findById(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }

        for (BookModel book : BOOKS) {
            if (book.getId().equalsIgnoreCase(id)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public BookModel update(String title) {
        if (title == null || title.isBlank()) {
            return null;
        }

        for (BookModel book : BOOKS) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public BookModel delete(String title) {
        BookModel book = search(title);

        if (book != null) {
            BOOKS.remove(book);
        }
        return book;
    }
}