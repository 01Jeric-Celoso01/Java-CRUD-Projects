package org.jcc.implement;

import org.jcc.db.BooksData;
import org.jcc.model.Books;
import org.jcc.repository.BooksRepository;
import org.jcc.ui.Design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BooksImplement implements BooksRepository {
    final List<Books> BOOKS = new ArrayList<>(BooksData.bookLists());

    @Override
    public Books register(Books b) {
        BOOKS.add(b);
        Design.status("SUCCESSFULLY REGISTER");
        return b;
    }

    @Override
    public List<Books> view() {
        return BOOKS;
    }

    @Override
    public Books update(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }

        for (Books b : BOOKS) {
            if (b.getId().equals(id)) {
                return b;
            }
        }

        return null;
    }

    @Override
    public Books delete(String id) {
        Iterator<Books> iterate = BOOKS.iterator();

        while (iterate.hasNext()) {
            Books b = iterate.next();

            if (b.getId().equals(id)) {
                iterate.remove();
                Design.status("SUCCESSFULLY REGISTER");
                return b;
            }
        }
        return null;
    }
}
