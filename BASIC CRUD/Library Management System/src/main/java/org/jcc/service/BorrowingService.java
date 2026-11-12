package org.jcc.service;

import org.jcc.enums.BorrowingStatus;
import org.jcc.model.BookModel;
import org.jcc.model.BorrowingModel;
import org.jcc.repository.BookRepository;
import org.jcc.repository.BorrowingRepository;

import java.util.List;

public class BorrowingService {

    private final BorrowingRepository BORROWING_REPOSITORY;
    private final BookRepository BOOK_REPOSITORY;

    public BorrowingService(BorrowingRepository BORROWING_REPOSITORY, BookRepository BOOK_REPOSITORY) {
        this.BORROWING_REPOSITORY = BORROWING_REPOSITORY;
        this.BOOK_REPOSITORY = BOOK_REPOSITORY;
    }

    public boolean registerService(BorrowingModel borrowing) {

        BookModel book = BOOK_REPOSITORY.findById(borrowing.getBookId());

        if (book == null) {
            System.out.println("BOOK NOT FOUND!");
            return false;
        }

        boolean success = book.borrowCopies(borrowing.getBorrowedQuantity());

        if (!success) {
            System.out.println("INSUFFICIENT COPIES!");
            return false;
        }

        BORROWING_REPOSITORY.save(borrowing);
        return true;
    }

    // VIEW ALL BORROWINGS
    public List<BorrowingModel> getAllBorrowings() {
        return BORROWING_REPOSITORY.findAll();
    }

    // SEARCH BORROWING
    public BorrowingModel getBorrowingById(String id) {

        if (id == null || id.isBlank()) {
            return null;
        }

        return BORROWING_REPOSITORY.findById(id);
    }

    public void initializeBorrowedCopies() {

        List<BorrowingModel> borrowings = BORROWING_REPOSITORY.findAll();

        for (BorrowingModel borrowing : borrowings) {

            BookModel book = BOOK_REPOSITORY.findById(borrowing.getBookId());

            if (book == null) {
                System.out.println("BOOK NOT FOUND: " + borrowing.getBookId());
                continue;
            }

            if (borrowing.getStatus() == BorrowingStatus.BORROWED) {

                boolean success = book.borrowCopies(borrowing.getBorrowedQuantity());

                if (!success) {
                    System.out.println("UNABLE TO PROCESS BORROWING: " + borrowing.getId());
                }
            }
        }
    }

    public boolean updateStatusById(String id, BorrowingStatus status) {

        BorrowingModel borrowing = BORROWING_REPOSITORY.updateById(id);

        if (borrowing == null) {
            return false;
        }

        borrowing.setStatus(status);

        return true;
    }
}