    
package org.jcc;

import org.jcc.controller.AdminController;
import org.jcc.controller.StudentController;
import org.jcc.controller.TeacherController;
import org.jcc.data.AdminSampleData;
import org.jcc.implement.StudentRepositoryImp;
import org.jcc.enums.AccountRole;
import org.jcc.model.Admin;
import org.jcc.model.Student;
import org.jcc.model.Teacher;
import org.jcc.repository.StudentRepository;
import org.jcc.service.StudentService;
import org.jcc.service.TeacherService;
import org.jcc.util.BorderLine;

import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static String choice;

    static void main() {

        StudentRepository studentRepository = new StudentRepositoryImp();
        StudentService studentService = new StudentService(studentRepository);
        StudentController studentController = new StudentController(studentService);

        TeacherService teacherService = new TeacherService();
        TeacherController teacherController = new TeacherController(teacherService, studentService);

        List<Admin> admins = AdminSampleData.getSampleAdmins();
        AdminController adminController = new AdminController(admins);

        while (true) {

            BorderLine.borderLine();
            BorderLine.titleMenu("STUDENT MANAGEMENT SYSTEM");
            BorderLine.displayChoice("0) EXIT SYSTEM     1) LOGIN ACCOUNT     2) REGISTER STUDENT ACCOUNT", 43);
            System.out.print("|| CHOOSE: ");
            choice = input.nextLine();
            BorderLine.borderLine();

            Admin admin = adminController.loginAdmin(choice, AccountRole.ADMIN);

            if (admin != null) { // ADMIN ACCOUNT ROLE
                while (true) {
                    System.out.println("\n\n\n");
                    admin.displayAdminInfo();
                    BorderLine.titleMenu("ADMIN MENU");
                    BorderLine.displayChoice("0) LOGOUT ACCOUNT     1) DISPLAY ALL STUDENTS     2) DISPLAY ALL TEACHERS", 25);
                    System.out.print("|| CHOOSE FUNCTION: ");
                    choice = input.nextLine();
                    BorderLine.borderLine();
                    System.out.println("\n");

                    if (choice.equals("0")) { break; }

                    switch (choice) {
                        case "1":
                            admin.displayAllStudents(studentService.displayAllStudents());
                            break;
                        case "2":
                            admin.displayAllTeachers(teacherService.getAllTeachers());
                            break;
                        default:
                            System.out.println("|| Invalid Choice!");
                            break;
                    }
                }
                continue;
            }

            if (choice.equals("0")) { break; }

            switch (choice) {
                case "1":
                    BorderLine.borderLine();
                    BorderLine.titleMenu("LOGIN ACCOUNT");
                    System.out.print("|| ENTER YOUR ID: ");
                    String id = input.nextLine();
                    BorderLine.borderLine();
                    BorderLine.titleMenu("SELECT ACCOUNT ROLE");
                    BorderLine.displayChoice("1) STUDENT ACCOUNT     2) TEACHER ACCOUNT", 52);
                    System.out.print("|| CHOOSE ROLE: ");
                    String roleChoice = input.nextLine();
                    BorderLine.borderLine();

                    if (roleChoice.equals("1")) {
                        Student student = studentService.searchStudentById(id);
                        if (student != null && student.getRole() == AccountRole.STUDENT) {
                            while (true) {
                                studentController.searchStudentById(student);
                                BorderLine.titleMenu("UPDATE STUDENT INFORMATION");
                                BorderLine.displayChoice("0) LOGOUT ACCOUNT     1) UPDATE INFORMATION", 67);
                                System.out.print("|| CHOOSE FUNCTION: ");
                                choice = input.nextLine();

                                if (choice.equals("0")) { break; }

                                switch (choice) {
                                    case "1":
                                        BorderLine.borderLine();
                                        BorderLine.displayChoice("0) EXIT FUNCTION     1) FIRST NAME     2) MIDDLE NAME     3) LAST NAME", 40);
                                        BorderLine.displayChoice("4) GENDER     5) BIRTH DAY     6) NUMBER     7) EMAIL", 57);
                                        studentController.specificUpdateStudent(student);
                                        break;
                                    default:
                                        System.out.println("Invalid Choice!");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("\nInvalid Student ID or Role!");
                        }
                    } else if (roleChoice.equals("2")) {
                        Teacher teacher = teacherService.getTeacherById(id);
                        if (teacher != null && teacher.getRole() == AccountRole.TEACHER) {
                            while (true) {
                                teacher.displayTeacherInfo();
                                BorderLine.displayChoice("0) LOGOUT ACCOUNT     1) REGISTER STUDENT     2) DISPLAY STUDENTS     3) UPDATE STUDENT GRADE", 17);
                                BorderLine.displayChoice("4) REGISTER SUBJECT", 91);
                                System.out.print("|| CHOOSE A FUNCTION: ");
                                choice = input.nextLine();
                                BorderLine.borderLine();

                                if (choice.equals("0")) { break; }

                                switch (choice) {
                                    case "1":
                                        teacherController.registerStudentInSubject(teacher);
                                        break;
                                    case "2":
                                        teacherController.displayTeacherStudents(teacher);
                                        break;
                                    case "3":
                                        teacherController.updateStudentGrade(teacher);
                                        break;
                                    case "4":
                                        teacherController.registerSubject(teacher);
                                        break;
                                    default:
                                        System.out.println("|| Invalid Choice!");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("\n|| Invalid Teacher ID or Role!");
                        }
                    } else {
                        System.out.println("\n|| Invalid Account Role!");
                    }
                    break;
                case "2":
                    BorderLine.borderLine();
                    System.out.printf("|| %-32s %-58s ||%n", " ", "REGISTER STUDENT ACCOUNT");
                    BorderLine.borderLine();
                    studentController.createdStudent();
                    break;
                default:
                    System.out.println("|| Invalid Choice!");
                    break;
            }
        }
    }
}
