package org.jcc.repository;

import org.jcc.model.Books;

import java.util.List;

public interface BooksRepository {
    Books register(Books b);
    List<Books> view();
    Books update(String id);
    Books delete(String id);
}
