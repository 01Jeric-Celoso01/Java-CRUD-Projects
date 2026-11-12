package org.jcc.model;

import java.time.LocalDate;

public class Product {
    private String id;
    private String name;
    private String description;
    private String category;
    private String brand;
    private double price;
    private int quantity;
    private int available;
    private String sku;
    private String barcode;
    private String supplier;
    private LocalDate dateAdded;
    private LocalDate dateExpired;
    private String status;

    public Product(String id, String name, String description, String category, String brand, double price, int quantity,
           String sku, String barcode, String supplier, LocalDate dateAdded, LocalDate dateExpired, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.sku = sku;
        this.barcode = barcode;
        this.supplier = supplier;
        this.dateAdded = dateAdded;
        this.dateExpired = dateExpired;
        this.status = status;
    }


    // GETTER STRUCTURE
    public String getId() { return id; }
    public String getName() { return name;}
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public String getBrand() { return brand; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getSku() { return sku;}
    public String getBarcode() { return barcode; }
    public String getSupplier() { return supplier; }
    public LocalDate getDateAdded() { return dateAdded; }
    public LocalDate getDateExpired() { return dateExpired; }
    public String getStatus() { return status; }


    // SETTER STRUCTURE
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(String category) { this.category = category; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setSku(String sku) { this.sku = sku; }
    public void setBarcode(String barcode) { this.barcode = barcode; }
    public void setSupplier(String supplier) { this.supplier = supplier; }
    public void setDateAdded(LocalDate dateAdded) { this.dateAdded = dateAdded; }
    public void setDateExpired(LocalDate dateExpired) { this.dateExpired = dateExpired; }
    public void setStatus(String status) { this.status = status; }
}
