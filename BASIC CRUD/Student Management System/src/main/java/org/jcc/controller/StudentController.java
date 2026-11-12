
package org.jcc.controller;

import org.jcc.model.Student;
import org.jcc.service.StudentService;
import org.jcc.util.BorderLine;

import java.util.List;
import java.util.Scanner;

public class StudentController {

    private final StudentService studentService;

    static final Scanner input = new Scanner(System.in);

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Create Student
    public Student createdStudent() {

        System.out.print("|| Enter Student First Name: ");
        String firstName = input.next();
        System.out.print("|| Enter Student Middle Name: ");
        String middleName = input.next();
        System.out.print("|| Enter Student Last Name: ");
        String lastName = input.next();
        System.out.print("|| Enter Student Gender: ");
        String gender = input.next();
        System.out.print("|| Enter Student Birth Date: ");
        String birthDate = input.next();
        System.out.print("|| Enter Student Number: ");
        String number = input.next();
        System.out.print("|| Enter Student Email: ");
        String email = input.next();
        System.out.print("|| Enter Student Grade Level: ");
        int gradeLevel = input.nextInt();
        input.nextLine();

        Student student = new Student(firstName, middleName, lastName, gender, birthDate, number, email, gradeLevel);

        Student createdStudent = studentService.createStudents(student);

        if (createdStudent != null) {
            System.out.println("Student Created Successfully!");
            System.out.println("Student ID: " + createdStudent.getId());
        } else {
            System.out.println("Student Creation Failed!");
        }

        return createdStudent;
    }

    // Display All Students
    public void displayTheStudents() {

        List<Student> allStudents = studentService.displayAllStudents();

        if (allStudents.isEmpty()) {
            System.out.println("Student List is Empty!");
            return;
        }

        for (Student student : allStudents) {
            student.displayInfo();
            student.displaySubjectAndGrades();
        }
    }

    // Update Student Information
    public void specificUpdateStudent(Student student) {

        while (true) {
            if (student == null || student.getId() == null) {
                System.out.println("Student Not Found!");
                return;
            }

            System.out.print("|| CHOOSE WHAT TO UPDATE: ");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 0) { break; }

            switch (choice) {

                case 1:
                    System.out.print("|| UPDATE FIRST NAME: ");
                    student.setFirstName(input.nextLine());
                    break;

                case 2:
                    System.out.print("|| UPDATE MIDDLE NAME: ");
                    student.setMiddleName(input.nextLine());
                    break;

                case 3:
                    System.out.print("|| UPDATE LAST NAME: ");
                    student.setLastName(input.nextLine());
                    break;

                case 4:
                    System.out.print("|| UPDATE GENDER: ");
                    student.setGender(input.nextLine());
                    break;

                case 5:
                    System.out.print("|| UPDATE BIRTH DAY (MMDDYYYY): ");
                    student.setBirthDate(input.nextLine());
                    break;

                case 6:
                    System.out.print("|| UPDATE NUMBER: ");
                    student.setNumber(input.nextLine());
                    break;

                case 7:
                    System.out.print("|| UPDATE EMAIL: ");
                    student.setEmail(input.nextLine());
                    break;

                default:
                    BorderLine.displayFeedback("Invalid Choice!");
                    return;
            }
            BorderLine.displayFeedback("Student Updated Successfully!");

            student.displayInfo();
        }
    }

    // Delete Student
    public void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");

        String id = input.nextLine();

        String result = studentService.deleteStudentById(id);

        System.out.println(result);
    }

    // Search Student by ID
    public void searchStudentById(Student student) {

        if (student == null || student.getId() == null) {
            System.out.println("Student Not Found!");
            return;
        }

        student.displayInfo();

        student.displaySubjectAndGrades();
    }
}
