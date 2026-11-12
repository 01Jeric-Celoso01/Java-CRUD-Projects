package org.jcc.controller;

import org.jcc.model.Product;
import org.jcc.service.ProductService;
import org.jcc.ui.Design;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    private final ProductService SERVICE;

    static Scanner input = new Scanner(System.in);

    public ProductController(ProductService service) {
        this.SERVICE = service;
    }

    public void registerProduct() {
        System.out.print("| ID           : ");
        String id = input.nextLine();

        System.out.print("| NAME         : ");
        String name = input.nextLine();

        System.out.print("| DESCRIPTION  : ");
        String description = input.nextLine();

        System.out.print("| CATEGORY     : ");
        String category = input.nextLine();

        System.out.print("| BRAND        : ");
        String brand = input.nextLine();

        System.out.print("| PRICE        : ");
        double price = input.nextDouble();

        System.out.print("| QUANTITY     : ");
        int quantity = input.nextInt();
        input.nextLine();

        System.out.print("| SKU          : ");
        String sku = input.nextLine();

        System.out.print("| BARCODE      : ");
        String barcode = input.nextLine();

        System.out.print("| SUPPLIER     : ");
        String supplier = input.nextLine();

        System.out.print("| START DATE   : ");
        LocalDate dateAdded = LocalDate.parse(input.nextLine());

        System.out.print("| DATE EXPIRE  : ");
        LocalDate dateExpired = LocalDate.parse(input.nextLine());

        System.out.print("| STATUS       : ");
        String status = input.nextLine();

        Product p = new Product(id, name, description, category, brand, price, quantity, sku, barcode, supplier, dateAdded, dateExpired, status);
        if (SERVICE.register(p)) {
            Design.border();
            Design.status("PRODUCT SUCCESSFULLY REGISTER");
            Design.border();
        } else {
            Design.border();
            Design.status("PRODUCT FAILED TO REGISTER");
            Design.border();
        }
    }



    public void viewAllProduct() {
        List<Product> products = SERVICE.view();

        for (Product p : products) {
            System.out.printf("| ID: %-20s | BARCODE: %-15s | SKU: %-39s | NAME: %-51s |\n", p.getId(), p.getBarcode(), p.getSku(), p.getName());
            System.out.printf("| PRICE: %-17s | QUANTITY: %-14s | AVAILABLE: %-33s | STATUS: %-49s |\n", p.getPrice(), p.getQuantity(), 50, p.getStatus());
            System.out.printf("| CATEGORY: %-41s | BRAND: %-37s | SUPPLIER: %-47s |\n", p.getCategory(), p.getBrand(), p.getSupplier());
            System.out.printf("| START DATE: %-12s | START DATE: %-119s |\n", p.getDateAdded(), p.getDateExpired());
            System.out.printf("| DESCRIPTION: %-145s |\n", p.getDescription());
        }
        Design.border();
    }



    public void updateProduct() {
        System.out.print("| ID: ");
        String id = input.nextLine();

        Product product = SERVICE.update(id);

        if(product.getId().equals(id)) {
            while (true) {
                Design.border();
                Design.choices("1) NAME   2) DESCRIPTION   3) CATEGORY   4) BRAND   5) PRICE   6) QUANTITY   7) SKU   8) BARCODE   9) SUPPLIER   10) START DATE   11) EXPIRE DATE   12) STATUS");
                Design.border();
                System.out.print("CHOOSE UPDATE: ");
                int choice = input.nextInt();

                if (choice == 0) {
                    break;
                }

                switch (choice) {
                    case 1:
                        System.out.print("| UPDATE NAME: ");
                        product.setName(input.nextLine());
                        break;
                    case 2:
                        System.out.print("| UPDATE DESCRIPTION: ");
                        product.setDescription(input.nextLine());
                        break;
                    case 3:
                        System.out.print("| UPDATE CATEGORY: ");
                        product.setCategory(input.nextLine());
                        break;
                    case 4:
                        System.out.print("| UPDATE BRAND: ");
                        product.setBrand(input.nextLine());
                        break;
                    case 5:
                        System.out.print("| UPDATE PRICE: ");
                        product.setPrice(input.nextDouble());
                        break;
                    case 6:
                        System.out.print("| UPDATE QUANTITY: ");
                        product.setQuantity(input.nextInt());
                        break;
                    case 7:
                        System.out.print("| UPDATE SKU: ");
                        product.setSku(input.nextLine());
                        break;
                    case 8:
                        System.out.print("| UPDATE BARCODE: ");
                        product.setBarcode(input.nextLine());
                        break;
                    case 9:
                        System.out.print("| UPDATE SUPPLIER: ");
                        product.setSupplier(input.nextLine());
                        break;
                    case 10:
                        System.out.print("| UPDATE START DATE: ");
                        product.setDateAdded(LocalDate.parse((input.nextLine())));
                        break;
                    case 11:
                        System.out.print("| UPDATE EXPIRE DATE: ");
                        product.setDateExpired(LocalDate.parse((input.nextLine())));
                        break;
                    case 12:
                        System.out.print("| UPDATE STATUS: ");
                        product.setStatus((input.nextLine()));
                        break;
                    default:
                        Design.status("INVALID CHOICE");
                        break;
                }
            }
        }

    }



    public void deleteProduct() {
        System.out.print("| ID: ");
        String id = input.nextLine();

        Product product = SERVICE.delete(id);

        if (product != null) {
            Design.border();
            Design.status(product.getName() + " SUCCESSFULLY DELETED");
            Design.border();
        } else {
            Design.border();
            Design.status("ID NOT FOUND PLEASE TRY AGAIN");
            Design.border();
        }
    }



    public void searchProduct() {
        System.out.print("| ID: ");
        String id = input.nextLine();

        Product p = SERVICE.search(id);

        Design.border();
        System.out.printf("| ID: %-20s | BARCODE: %-15s | SKU: %-39s | NAME: %-51s |\n", p.getId(), p.getBarcode(), p.getSku(), p.getName());
        System.out.printf("| PRICE: %-17s | QUANTITY: %-14s | AVAILABLE: %-33s | STATUS: %-49s |\n", p.getPrice(), p.getQuantity(), 50, p.getStatus());
        System.out.printf("| CATEGORY: %-41s | BRAND: %-37s | SUPPLIER: %-47s |\n", p.getCategory(), p.getBrand(), p.getSupplier());
        System.out.printf("| START DATE: %-12s | START DATE: %-119s |\n", p.getDateAdded(), p.getDateExpired());
        System.out.printf("| DESCRIPTION: %-145s |\n", p.getDescription());
        Design.border();
    }
}
