package org.jcc;

import org.jcc.controller.CourseController;
import org.jcc.ui.Design;

import java.util.Scanner;

public class MainCourse {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        CourseController course = new CourseController(input);

        while (true) {
            Design.addNewLine();
            Design.border();
            Design.title("COURSE MANAGEMENT SYSTEM");
            Design.border();
            Design.choices("0) EXIT SYSTEM     1) REGISTER      2) VIEW ALL     3) SEARCH     4) UPDATE     5) DELETE");
            Design.border();
            System.out.print("||| CHOOSE FUNCTION: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 0) {
                Design.border();
                Design.status("EXIT SYSTEM...");
                Design.border();
                break;
            } else if (choice == 1) {
                Design.addNewLine();
                Design.border();
                Design.title("REGISTER COURSE");
                Design.border();
                course.registerController();
            } else if (choice == 2) {
                Design.addNewLine();
                Design.border();
                Design.title("VIEW ALL COURSES");
                Design.border();
                course.viewAllController();
            } else if (choice == 3) {
                Design.addNewLine();
                Design.border();
                Design.title("SEARCH COURSE");
                Design.border();
                course.searchController();
            } else if (choice == 4) {
                Design.addNewLine();
                Design.border();
                Design.title("UPDATE COURSE");
                Design.border();
                course.updateController();
            } else if (choice == 5) {
                Design.addNewLine();
                Design.border();
                Design.title("DELETE COURSE");
                Design.border();
                course.deleteController();
            } else {
                Design.border();
                Design.status("INVALID CHOICE PLEASE TRY AGAIN");
                Design.border();
            }
        }
    }
}
