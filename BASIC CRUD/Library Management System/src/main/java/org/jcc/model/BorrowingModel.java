package org.jcc.model;

import org.jcc.enums.BorrowingStatus;

import java.time.LocalDate;

public class BorrowingModel {

    private String id;
    private String bookId;
    private String borrowerId;
    private int borrowedQuantity;

    private LocalDate startDate;
    private LocalDate dueDate;
    private String returnDate;

    private BorrowingStatus status;

    public BorrowingModel(String id, String bookId, String borrowerId, int borrowedQuantity, LocalDate startDate, LocalDate dueDate) {
        this.id = id;
        this.bookId = bookId;
        this.borrowerId = borrowerId;
        this.borrowedQuantity = borrowedQuantity;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.status = BorrowingStatus.BORROWED;
    }

    public String getId() { return id; }
    public String getBookId() {
        return bookId;
    }
    public String getBorrowerId() {
        return borrowerId;
    }
    public int getBorrowedQuantity() {
        return borrowedQuantity;
    }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public String getReturnDate() {
        return returnDate;
    }
    public BorrowingStatus getStatus() {
        return status;
    }

    public void setId(String id) { this.id = id; }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }
    public void setBorrowedQuantity(int borrowedQuantity) {
        this.borrowedQuantity = borrowedQuantity;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
    public void setStatus(BorrowingStatus status) {
        this.status = status;
    }
}