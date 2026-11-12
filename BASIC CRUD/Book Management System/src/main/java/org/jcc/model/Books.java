package org.jcc.model;

import org.jcc.enums.Category;

public class Books {
    private String id;
    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private int year;
    private int quantity;
    private Category category;

    public Books(String id, String title, String author, String publisher, String isbn, int year, int quantity, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.year = year;
        this.quantity = quantity;
        this.category = category;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }
    public String getIsbn() { return isbn; }
    public int getYear() { return year; }
    public int getQuantity() { return quantity; }
    public Category getCategory() { return category; }


    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setIsbn(String isbn) { this.isbn = isbn;}
    public void setYear(int year) { this.year = year; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setCategory(Category category) { this.category = category; }
}
