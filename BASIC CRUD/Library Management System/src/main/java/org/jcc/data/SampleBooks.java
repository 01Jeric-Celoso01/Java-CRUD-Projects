package org.jcc.data;

import org.jcc.enums.BookCategory;
import org.jcc.model.BookModel;
import org.jcc.util.GenerateId;

import java.util.ArrayList;
import java.util.List;

public class SampleBooks {

    public static List<BookModel> sampleBooks() {

        List<BookModel> data = new ArrayList<>();

        BookModel book1 = new BookModel(GenerateId.generateBookId(), "Clean Code", "Robert C. Martin", "9780132350884", "Prentice Hall", BookCategory.TECHNOLOGY, 2008, 5, 5);
        data.add(book1);

        BookModel book2 = new BookModel(GenerateId.generateBookId(), "Java", "James Gosling", "1478523690357", "Sun Microsystems", BookCategory.TECHNOLOGY, 1995, 2, 2);
        data.add(book2);

        return data;
    }
}