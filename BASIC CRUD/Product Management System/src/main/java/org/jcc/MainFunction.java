package org.jcc;

import org.jcc.controller.ProductController;
import org.jcc.implement.ProductImplement;
import org.jcc.service.ProductService;
import org.jcc.ui.Design;

import java.util.Scanner;

public class MainFunction {
    static void main() {
        Scanner input = new Scanner(System.in);

        ProductImplement productImplement = new ProductImplement();
        ProductService productService = new ProductService(productImplement);
        ProductController productController = new ProductController(productService);

        int choice = 0;

        while (true) {
            Design.newLine();
            Design.border();
            Design.title("PRODUCT MANAGEMENT SYSTEM");
            Design.border();
            Design.choices("0) EXIT SYSTEM     1) REGISTER PRODUCT     2) VIEW PRODUCTS     3) UPDATE PRODUCT     4) DELETE PRODUCT   5) SEARCH PRODUCT");
            Design.border();
            System.out.print("| CHOOSE: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 0) {
                break;
            } else if (choice == 1) {
                Design.newLine();
                Design.border();
                Design.title("REGISTER THE PRODUCTS");
                Design.border();
                productController.registerProduct();
            } else if (choice == 2) {
                Design.newLine();
                Design.border();
                Design.title("VIEW ALL THE PRODUCTS");
                Design.border();
                productController.viewAllProduct();
            } else if (choice == 3) {
                Design.newLine();
                Design.border();
                Design.title("UPDATE THE PRODUCTS");
                Design.border();
                productController.updateProduct();
            } else if (choice == 4) {
                Design.newLine();
                Design.border();
                Design.title("DELETE THE PRODUCTS");
                Design.border();
                productController.deleteProduct();
            } else if (choice == 5) {
                Design.newLine();
                Design.border();
                Design.title("SEARCH THE PRODUCTS");
                Design.border();
                productController.searchProduct();
            } else {
                Design.status("INVALID CHOICE");
            }
        }
    }
}
