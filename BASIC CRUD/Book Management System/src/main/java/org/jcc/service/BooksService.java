package org.jcc.service;

import org.jcc.implement.BooksImplement;
import org.jcc.model.Books;

import java.util.List;

public class BooksService {
    private final BooksImplement implement;

    public BooksService(BooksImplement implement) {
        this.implement = implement;
    }

    public Books registerService(Books b) {
        return implement.register(b);
    }

    public List<Books> viewService() {
        return implement.view();
    }

    public Books updateService(String id) {
        return implement.update(id);
    }

    public Books deleteService(String id) {
        return implement.delete(id);
    }
}
