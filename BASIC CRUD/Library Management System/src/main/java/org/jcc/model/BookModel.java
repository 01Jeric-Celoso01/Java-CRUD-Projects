package org.jcc.model;

import org.jcc.enums.BookCategory;

public class BookModel {

    private String id;
    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private BookCategory category;
    private int publicationYear;
    private int quantity;
    private int availableCopies;

    public BookModel(String id, String title, String author, String isbn, String publisher, BookCategory category, int publicationYear, int quantity, int availableCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.category = category;
        this.publicationYear = publicationYear;
        this.quantity = quantity;
        this.availableCopies = availableCopies;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        if (availableCopies < 0 || availableCopies > quantity) {
            throw new IllegalArgumentException("Invalid available copies!");
        }

        this.availableCopies = availableCopies;
    }

    // BORROW BOOK
    public boolean borrowCopies(int borrowedQuantity) {

        if (borrowedQuantity <= 0 || borrowedQuantity > availableCopies) {
            return false;
        }

        availableCopies -= borrowedQuantity;

        return true;
    }

    // RETURN BOOK
    public boolean returnCopies(int returnedQuantity) {

        if (returnedQuantity <= 0 || returnedQuantity > quantity - availableCopies) {
            return false;
        }

        availableCopies += returnedQuantity;

        return true;
    }
}