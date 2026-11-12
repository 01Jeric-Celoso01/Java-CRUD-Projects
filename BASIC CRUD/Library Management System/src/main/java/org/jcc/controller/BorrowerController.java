package org.jcc.controller;

import org.jcc.implement.BorrowerImplementation;
import org.jcc.model.BorrowerModel;
import org.jcc.service.BorrowerService;
import org.jcc.ui.Design;
import org.jcc.util.GenerateId;

import java.util.List;
import java.util.Scanner;

public class BorrowerController {

    static Scanner input = new Scanner(System.in);

    static int choice;

    static BorrowerImplementation IMPLEMENT = new BorrowerImplementation();
    static final BorrowerService SERVICE = new BorrowerService(IMPLEMENT);

    public static void registerBorrowerController() {
        String id = GenerateId.generateBorrowerId();
        System.out.print("| FIRST NAME: ");
        String fName = input.nextLine();
        System.out.print("| MIDDLE NAME : ");
        String mName = input.nextLine();
        System.out.print("| LAST NAME: ");
        String lName = input.nextLine();
        System.out.print("| GENDER: ");
        String gender = input.nextLine();
        System.out.print("| NUMBER: ");
        String number = input.nextLine();
        System.out.print("| EMAIL : ");
        String email = input.nextLine();
        System.out.print("| ADDRESS : ");
        String address = input.nextLine();

        BorrowerModel borrower = new BorrowerModel(id, fName, mName, lName, gender, number, email, address);
        SERVICE.registerBorrower(borrower);

        Design.border();
        Design.status("REGISTER COMPLETE");
        Design.border();
    }



    public static void viewAllBorrowerController() {
        List<BorrowerModel> borrowers = SERVICE.viewAll();

        if (borrowers.isEmpty()) {
            System.out.printf("| %-24s || %-20s || %-13s || %-24s || %-11s || %-48s |\n", "ACCOUNT ID", "FULL NAME", "GENDER", "NUMBER", "EMAIL", "ADDRESS");
            Design.status("NO BORROWER REGISTER");
            Design.border();
            return;
        }

        System.out.printf("| %-10s || %-25s || %-6s || %-11s || %-36s || %-52s |\n", "ACCOUNT ID", "FULL NAME", "GENDER", "NUMBER", "EMAIL", "ADDRESS");
        Design.border();
        for (BorrowerModel br : borrowers) {
            System.out.printf("| %-10s || %-25s || %-6s || %-11s || %-36s || %-52s |\n", br.getId(), br.getFullName(), br.getGender(), br.getNumber(), br.getEmail(), br.getAddress());
        }
        Design.border();
    }



    public static void searchBorrowerById() {
        System.out.print("| ACCOUND ID: ");
        String id = input.nextLine();
        Design.border();
        BorrowerModel br = SERVICE.searchById(id);

        if (br != null) {
            System.out.printf("| ACCOUNT ID-: %-147s |\n", br.getId());
            System.out.printf("| FULL NAME--: %-147s |\n", br.getFullName());
            System.out.printf("| GENDER-----: %-147s |\n", br.getGender());
            System.out.printf("| NUMBER-----: %-147s |\n", br.getNumber());
            System.out.printf("| EMAIL------: %-147s |\n", br.getEmail());
            System.out.printf("| ADDRESS----: %-147s |\n", br.getAddress());
            Design.border();
        } else {
            Design.status("ID NOT FOUND");
        }
    }



    public static void updateBorrowerById() {
        System.out.print("| ACCOUNT ID: ");
        String id = input.nextLine();
        Design.border();
        BorrowerModel br = SERVICE.updateById(id);

        if (br != null) {
            Design.choices("1) FIRST NAME   2) MIDDLE NAME   3) LAST NAME   4) GENDER   5) NUMBER   6) EMAIL   7) ADDRESS");
            Design.border();
            System.out.print("| ACCOUNT ID: ");
            choice = input.nextInt();
            input.nextLine();
            Design.border();

            switch (choice) {
                case 1:
                    System.out.print("| UPDATE FIRST NAME: ");
                    br.setfName(input.nextLine());
                    break;
                case 2:
                    System.out.print("| UPDATE MIDDLE NAME: ");
                    br.setmName(input.nextLine());
                    break;
                case 3:
                    System.out.print("| UPDATE LAST NAME: ");
                    br.setlName(input.nextLine());
                    break;
                case 4:
                    System.out.print("| UPDATE GENDER: ");
                    br.setGender(input.nextLine());
                    break;
                case 5:
                    System.out.print("| UPDATE NUMBER: ");
                    br.setNumber(input.nextLine());
                    break;
                case 6:
                    System.out.print("| UPDATE EMAIL");
                    br.setEmail(input.nextLine());
                    break;
                case 7:
                    System.out.print("| UPDATE ADDRESS: ");
                    br.setAddress(input.nextLine());
                    break;
                default:
                    Design.status("INVALID INPUT: ");
                    break;
            }
        }
    }



    public static void deleteBorrowerById() {
        System.out.print("ACCOUND ID: ");
        String id = input.nextLine();

        BorrowerModel br = SERVICE.deleteById(id);
        Design.status("ACCOUNT SUCCESSFULLY DELETED");
    }
}
