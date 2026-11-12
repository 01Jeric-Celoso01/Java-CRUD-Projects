package org.jcc;

import org.jcc.controller.EmployeeController;
import org.jcc.implement.EmployeeRepositoryImp;
import org.jcc.service.EmployeeService;
import org.jcc.ui.UIDesign;

import java.util.Scanner;

public class EmployeeMain {
    static Scanner input = new Scanner(System.in);
    public static int choice;

    private static final EmployeeRepositoryImp employeeRepositoryImp = new EmployeeRepositoryImp();
    private static final EmployeeService employeeService = new EmployeeService(employeeRepositoryImp);
    private static final EmployeeController employeeController = new EmployeeController(employeeService);

    static void main(String[] args) {
        while (true) {
            UIDesign.crossBorder();
            UIDesign.titleDesign("EMPLOYEE MANAGEMENT SYSTEM");
            UIDesign.crossBorder();
            UIDesign.choiceDesign("0) EXIT FUNCTION   1) REGISTER EMPLOYEE   2) VIEW ALL EMPLOYEE   3) SEARCH EMPLOYEE   4) UPDATE EMPLOYEE   5) DELETE EMPLOYEE");
            UIDesign.crossBorder();

            System.out.print("|| CHOOSE A FUNCTION: ");
            choice = input.nextInt();
            UIDesign.crossBorder();

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("\n\n");
                    UIDesign.crossBorder();
                    UIDesign.titleDesign("REGISTER EMPLOYEE");
                    UIDesign.crossBorder();
                    employeeController.registerEmployeeController();
                    System.out.println("\n\n");
                    break;
                case 2:
                    System.out.println("\n\n");
                    UIDesign.crossBorder();
                    UIDesign.titleDesign("LIST OF EMPLOYEES");
                    UIDesign.crossBorder();
                    employeeController.viewAllEmployeesController();
                    break;
                case 3:
                    System.out.println("\n\n");
                    UIDesign.crossBorder();
                    UIDesign.titleDesign("SEARCHED EMPLOYEE");
                    UIDesign.crossBorder();
                    employeeController.viewEmployeeByIdController();
                    break;
                case 4:
                    System.out.println("\n\n");
                    UIDesign.crossBorder();
                    UIDesign.titleDesign("UPDATE EMPLOYEE");
                    UIDesign.crossBorder();
                    employeeController.updateEmployeeByIdController();
                    break;
                case 5:
                    System.out.println("\n\n");
                    UIDesign.crossBorder();
                    UIDesign.titleDesign("DELETE EMPLOYEE");
                    UIDesign.crossBorder();
                    employeeController.deleteEmployeeByIdController();
                    break;
                default:
                    UIDesign.statusDesign("INVALID CHOICE");
                    break;
            }
        }
    }
}
