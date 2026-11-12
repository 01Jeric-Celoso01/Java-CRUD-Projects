package org.jcc.controller;

import org.jcc.enums.BorrowingStatus;
import org.jcc.model.BorrowingModel;
import org.jcc.service.BorrowingService;
import org.jcc.ui.Design;
import org.jcc.util.GenerateId;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class BorrowingController {

    private final Scanner input = new Scanner(System.in);

    private final BorrowingService SERVICE;

    public BorrowingController(BorrowingService SERVICE) {
        this.SERVICE = SERVICE;
    }

    // REGISTER BORROWED BOOK
    public  void registerBorrowedController() {
        String id = GenerateId.generateBorrowingId();

        System.out.print("| BOOK ID: ");
        String bookId = input.nextLine();

        System.out.print("| BORROWER ID: ");
        String borrowerId = input.nextLine();

        System.out.print("| BORROWED QUANTITY: ");
        int borrowedQuantity = Integer.parseInt(input.nextLine());

        LocalDate currentDate = LocalDate.now();

        System.out.print("| DAYS BORROW: ");
        int days = input.nextInt();

        LocalDate dueDate = currentDate.plusDays(days);

        BorrowingModel borrowing = new BorrowingModel(id, bookId, borrowerId, borrowedQuantity, currentDate, dueDate);

        if (SERVICE.registerService(borrowing)) {
            Design.border();
            Design.status("BORROWED SUCCESSFULLY");
            Design.border();
        } else {
            Design.border();
            Design.status("BORROWING FAILED");
            Design.border();
        }
    }


    // VIEW ALL BORROWINGS
    public void viewAllBorrowingsController() {
        if (SERVICE.getAllBorrowings().isEmpty()) {
            Design.status("NO BORROWING RECORDS FOUND");
            return;
        }

        Design.border();
        System.out.printf("| %-17s | %-17s | %-17s | %-14s | %-14s | %-17s | %-14s | %-14s | %-12s |\n", "BORROWING ID", "BOOK ID", "BORROWER ID", "QUANTITY", "START DATE", "DUE DATE", "OVER DUE", "PENALTY", "STATUS");
        Design.border();
        for (BorrowingModel borrowing : SERVICE.getAllBorrowings()) {
            long overDueResult = 0;
            double priceResult = 0;

            double price = 15;
            int quantity = borrowing.getBorrowedQuantity();

            if (LocalDate.now().isAfter(borrowing.getDueDate())) {
                overDueResult = ChronoUnit.DAYS.between(borrowing.getDueDate(), LocalDate.now());
            } else {
                overDueResult = 0;
            }

            if (overDueResult > 0) {
                priceResult = price * quantity;
                borrowing.setStatus(BorrowingStatus.OVERDUE);
            } else {
                priceResult = 0;
            }


            System.out.printf("| %-17s | %-17s | %-17s | %-14s | %-14s | %-17s | DAY: %-9s | ₱%-13s | %-12s |\n", borrowing.getId(), borrowing.getBookId(), borrowing.getBorrowerId(), borrowing.getBorrowedQuantity(), borrowing.getStartDate(), borrowing.getDueDate(), overDueResult, priceResult, borrowing.getStatus());
        }
        Design.border();
    }




    public void updateStatus() {
        System.out.print("ENTER BORROWING ID: ");
        String id = input.nextLine();

        System.out.print("ENTER NEW STATUS (BORROWED, RETURNED, OVERDUE, LOST): ");
        String statusInput = input.nextLine().toUpperCase();

        try {

            BorrowingStatus status = BorrowingStatus.valueOf(statusInput);

            boolean success = SERVICE.updateStatusById(id, status);

            if (success) {
                Design.status("STATUS UPDATED SUCCESSFULLY!");
            } else {
                Design.status("BORROWING ID NOT FOUND!");
            }

        } catch (IllegalArgumentException e) {
            Design.status("INVALID BORROWING STATUS!");
        }

        Design.border();
    }
}