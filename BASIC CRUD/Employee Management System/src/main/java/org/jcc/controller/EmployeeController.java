package org.jcc.controller;

import org.jcc.enums.Departments;
import org.jcc.enums.EmployeeType;
import org.jcc.enums.Positions;
import org.jcc.model.Employee;
import org.jcc.service.EmployeeService;
import org.jcc.ui.UIDesign;
import org.jcc.util.GenerateAge;
import org.jcc.util.GenerateCurrentDate;
import org.jcc.util.GenerateEmployeeID;

import java.util.List;
import java.util.Scanner;

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    static Scanner input = new Scanner(System.in);

    // REGISTER EMPLOYEE METHOD
    public void registerEmployeeController() {
        String employeeId = GenerateEmployeeID.generateEmployeeId();

        System.out.print("|| FIRST NAME: ");
        String fName = input.next();

        System.out.print("|| MIDDLE NAME: ");
        String mName = input.next();

        System.out.print("|| LAST NAME: ");
        String lName = input.next();

        System.out.print("|| GENDER: ");
        String gender = input.next();

        System.out.print("|| BIRTH DAY: ");
        String birthDate = input.next();

        long age = GenerateAge.generateAge(birthDate);

        System.out.print("|| NUMBER: ");
        String number = input.next();

        System.out.print("|| EMAIL: ");
        String email = input.next();

        System.out.print("|| ADDRESS: ");
        String address = input.next();
        input.nextLine();

        Departments departments = null;
        while (departments == null) {
            UIDesign.crossBorder();
            UIDesign.choiceDesign("1) HUMAN RESOURCES   2) INFORMATION TECHNOLOGY   3) FINANCE   4) ACCOUNTING   5) MARKETING   6) SALES   7) OPERATIONS");
            UIDesign.choiceDesign("8) ADMINISTRATION   9) CUSTOMER SERVICE   10) ENGINEERING   11) PRODUCTION   12) QUALITY ASSURANCE   13) LOGISTICS");
            UIDesign.choiceDesign("14) WAREHOUSE   15) PURCHASING   16) RESEARCH_AND_DEVELOPMENT   17) LEGAL   18) SECURITY   19) PUBLIC_RELATIONS");
            UIDesign.crossBorder();

            System.out.print("|| DEPARTMENT: ");
            int depart = input.nextInt();
            if (depart >= 1 && depart <= Departments.values().length) {
                departments = Departments.values()[depart - 1];
            } else {
                UIDesign.statusDesign("INVALID CHOICE");
            }
        }

        String[] availablePositions = Positions.getPositions(departments);
        String position = null;
        while (position == null) {

            UIDesign.crossBorder();
            Positions.displayPositions(departments);
            UIDesign.crossBorder();
            System.out.print("|| POSITION: ");
            int choice = input.nextInt();

            if (choice >= 1 && choice <= availablePositions.length) {
                position = availablePositions[choice - 1];
            } else {
                UIDesign.statusDesign("INVALID POSITION");
            }
        }
        UIDesign.crossBorder();

        UIDesign.choiceDesign("1) FULL TIME   2) PART TIME   3) CONTRACTUAL   4) TEMPORARY   5) PROBATIONARY   6) PERMANENT   7) CASUAL");
        UIDesign.choiceDesign("8) REGULAR 9) PROJECT BASED 10) SEASONAL 11) INTERN   12) Trainee");
        UIDesign.crossBorder();
        System.out.print("|| EMPLOYEE TYPE: ");
        int type = input.nextInt();

        EmployeeType employeeType = null;
        if (type >= 1 && type <= EmployeeType.values().length) {
            employeeType = EmployeeType.values()[type - 1];
        }

        String dateHired = GenerateCurrentDate.currentDate();

        System.out.print("|| SALARY: ");
        double salary = input.nextDouble();

        Employee employee = new Employee(employeeId, fName, mName, lName, gender, birthDate, (int) age, number, email, address, departments, position, employeeType, dateHired, salary);
        employeeService.registerEmployee(employee);
        UIDesign.statusDesign("EMPLOYEE SUCCESSFULLY REGISTERED");
        UIDesign.crossBorder();
    }


    // VIEW ALL EMPLOYEE METHOD
    public void viewAllEmployeesController() {
        List<Employee> listOfEmployee = employeeService.viewAllEmployees();

        if (listOfEmployee.isEmpty()) {
            UIDesign.crossBorder();
            System.out.printf("|| %-9s || %-30s || %-30s || %-30s || %-13s|| %-12s || %-12s ||\n", "EMPLOYEE ID",  "FULL NAME", "DEPARTMENT", "POSITION", "EMPLOYEE TYPE", "SALARY", "DATE HIRED");
            UIDesign.crossBorder();
            UIDesign.choiceDesign("EMPTY LIST EMPLOYEE");
        }

        UIDesign.crossBorder();
        System.out.printf("|| %-11s || %-28s || %-34s || %-33s || %-13s|| %-9s || %-10s || \n", "EMPLOYEE ID",  "FULL NAME", "DEPARTMENT", "POSITION", "EMPLOYEE TYPE", "SALARY", "DATE HIRED");
        UIDesign.crossBorder();
        for (Employee employees : listOfEmployee) {
            System.out.printf("|| %-11s || %-28s || %-34s || %-33s || %-13s|| %-9s || %-10s || \n", employees.getId(), employees.getFullName(), employees.getDepartment(), employees.getPosition(), employees.getEmployeeType(), employees.getSalary(), employees.getHiredDate());

        }
    }


    // VIEW EMPLOYEE BY ID METHOD
    public void viewEmployeeByIdController() {
        System.out.print("|| ENTER EMPLOYEE ID: ");
        String employeeId = input.next();

        Employee employee = employeeService.searchEmployeeById(employeeId);

        if (employee != null) {
            employee.employeeById();
        } else {
            UIDesign.statusDesign("EMPLOYEE ID NOT FOUND");
        }
    }


    // UPDATE EMPLOYEE BY ID
    public void updateEmployeeByIdController() {
        System.out.print("|| ENTER EMPLOYEE ID: ");
        String employeeId = input.next();

        Employee employee = employeeService.updateEmployeeById(employeeId);

        if (employee == null) {
            UIDesign.statusDesign("|| EMPLOYEE NOT FOUND");
        } else {

            UIDesign.choiceDesign("1) FIRST NAME   2) MIDDLE NAME   3) LAST NAME   4) GENDER   5) BIRTH DAY   6) NUMBER   7) EMAIL");
            UIDesign.choiceDesign("8) ADDRESS   9) DEPARTMENT   10) POSITION   11) SALARY");
            UIDesign.crossBorder();

            int choice = 0;
            System.out.print("|| CHOOSE TO UPDATE: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("|| UPDATE FIRST NAME: ");
                    employee.setfName(input.next());
                    UIDesign.statusDesign("UPDATE SUCCESSFULLY");
                    break;
                case 2:
                    System.out.print("|| UPDATE MIDDLE NAME: ");
                    employee.setmName(input.next());
                    UIDesign.statusDesign("UPDATE SUCCESSFULLY");
                    break;
                case 3:
                    System.out.print("|| UPDATE LAST NAME: ");
                    employee.setlName(input.next());
                    UIDesign.statusDesign("UPDATE SUCCESSFULLY");
                    break;
                case 4:
                    System.out.print("|| UPDATE GENDER: ");
                    employee.setGender(input.next());
                    UIDesign.statusDesign("UPDATE SUCCESSFULLY");
                    break;
                case 5:
                    System.out.print("|| UPDATE BIRTH DAY: ");
                    employee.setBirthDate(input.next());
                    UIDesign.statusDesign("UPDATE SUCCESSFULLY");
                    break;
                case 6:
                    System.out.print("|| UPDATE NUMBER: ");
                    employee.setNumber(input.next());
                    UIDesign.statusDesign("UPDATE SUCCESSFULLY");
                    break;
                case 7:
                    System.out.print("|| UPDATE EMAIL: ");
                    employee.setEmail(input.next());
                    UIDesign.statusDesign("UPDATE SUCCESSFULLY");
                    break;
                case 8:
                    System.out.print("|| UPDATE ADDRESS: ");
                    employee.setAddress(input.next());
                    UIDesign.statusDesign("UPDATE SUCCESSFULLY");
                    break;
                case 9:
                    Departments[] departments = Departments.values();

                    UIDesign.crossBorder();
                    UIDesign.choiceDesign("1) HUMAN RESOURCES   2) INFORMATION TECHNOLOGY   3) FINANCE   4) ACCOUNTING   5) MARKETING   6) SALES   7) OPERATIONS");
                    UIDesign.choiceDesign("8) ADMINISTRATION   9) CUSTOMER SERVICE   10) ENGINEERING   11) PRODUCTION   12) QUALITY ASSURANCE   13) LOGISTICS");
                    UIDesign.choiceDesign("14) WAREHOUSE   15) PURCHASING   16) RESEARCH_AND_DEVELOPMENT   17) LEGAL   18) SECURITY   19) PUBLIC_RELATIONS");
                    UIDesign.crossBorder();

                    System.out.print("|| UPDATE DEPARTMENT: ");
                    int departmentChoice = input.nextInt();

                    if (departmentChoice >= 1 && departmentChoice <= departments.length) {
                        Departments newDepartment = departments[departmentChoice - 1];
                        employee.setDepartment(newDepartment);
                        String[] availablePositions = Positions.getPositions(newDepartment);
                        System.out.println("\n|| AVAILABLE POSITIONS:");

                        UIDesign.crossBorder();
                        Positions.displayPositions(newDepartment);
                        UIDesign.crossBorder();

                        System.out.print("|| UPDATE POSITION: ");
                        int positionChoice = input.nextInt();

                        if (positionChoice >= 1 && positionChoice <= availablePositions.length) {
                            employee.setPosition(availablePositions[positionChoice - 1]);
                            UIDesign.statusDesign("|| DEPARTMENT AND POSITION SUCCESSFULLY UPDATED");
                        } else {
                            UIDesign.statusDesign("|| INVALID POSITION");
                        }

                    } else {
                        UIDesign.statusDesign("INVALID DEPARTMENT");
                    }
                    UIDesign.statusDesign("UPDATE SUCCESSFULLY");
                    break;
                case 10:
                    EmployeeType[] types = EmployeeType.values();

                    for (int i = 0; i < types.length; i++) {
                        System.out.println((i + 1) + ") " + types[i]);
                    }

                    System.out.print("|| UPDATE EMPLOYEE TYPE: ");
                    int typeChoice = input.nextInt();

                    if (typeChoice >= 1 && typeChoice <= types.length) {
                        employee.setEmployeeType(types[typeChoice - 1]);
                    } else {
                        UIDesign.statusDesign("|| INVALID EMPLOYEE TYPE");
                        break;
                    }
                    UIDesign.statusDesign("UPDATE SUCCESSFULLY");
                    break;
                case 11:
                    System.out.print("|| UPDATE SALARY: ");
                    employee.setSalary(input.nextDouble());
                    UIDesign.statusDesign("UPDATE SUCCESSFULLY");
                    break;
                default:
                    UIDesign.statusDesign("INVALID CHOICE");
                    break;
            }
        }
    }


    // DELETE EMPLOYEE BY ID
    public void deleteEmployeeByIdController() {
        System.out.print("|| ENTER EMPLOYEE ID: ");
        String employeeId = input.next();

        Employee employee = employeeService.deleteEmployeeById(employeeId);
        UIDesign.statusDesign("EMPLOYEE SUCCESSFULLY DELETED");
    }
}
