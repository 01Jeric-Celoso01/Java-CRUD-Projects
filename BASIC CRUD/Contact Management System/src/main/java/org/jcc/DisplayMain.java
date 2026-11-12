package org.jcc;

import org.jcc.controllers.ContactController;
import org.jcc.ui.Design;

import java.util.Scanner;

public class DisplayMain {
    static void main() {

        Scanner input = new Scanner(System.in);
        ContactController contactController = new ContactController(input);

        int choice;

        while (true) {
            Design.addNewLine();
            Design.border();
            Design.title("CONTACT MANAGEMENT SYSTEM");
            Design.border();
            Design.choices("0) EXIT SYSTEM     1) ADD CONTACT     2) VIEW ALL CONTACT     3) UPDATE CONTACT     4) DELETE CONTACT     5) SEARCH ID CONTACT");
            Design.border();
            System.out.print("||| CHOOSE FUNCTION: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 0) {
                Design.status("EXIT CMD SYSTEM...");
                break;
            } else if (choice == 1) {
                Design.addNewLine();
                Design.border();
                Design.title("ADD CONTACTS");
                Design.border();
                contactController.registerController();
                Design.border();
            } else if (choice == 2) {
                Design.addNewLine();
                Design.border();
                Design.title("VIEW ALL CONTACTS");
                Design.border();
                contactController.viewAllController();
                Design.border();
            } else if (choice == 3) {
                Design.addNewLine();
                Design.border();
                Design.title("UPDATE THE CONTACTS");
                Design.border();
                contactController.updateController();
                Design.border();
            } else if (choice == 4) {
                Design.addNewLine();
                Design.border();
                Design.title("DELETE THE CONTACT");
                Design.border();
                contactController.deleteController();
                Design.border();
            } else if (choice == 5) {
                Design.addNewLine();
                Design.border();
                Design.title("SEARCH ID CONTACT");
                Design.border();
            } else {
                Design.status("INVALID INPUT CHOICE PLEASE TRY AGAIN");
            }
        }
    }
}
