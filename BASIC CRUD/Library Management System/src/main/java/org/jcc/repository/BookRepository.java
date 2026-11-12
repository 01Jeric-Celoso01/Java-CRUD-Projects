package org.jcc.repository;

import org.jcc.model.BookModel;

import java.util.List;

public interface BookRepository {
    BookModel create(BookModel book);
    List<BookModel> view();
    BookModel search(String title);
    BookModel findById(String id);
    BookModel update(String title);
    BookModel delete(String title);
}