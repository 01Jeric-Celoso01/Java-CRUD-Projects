
package org.jcc.controller;

import org.jcc.model.Student;
import org.jcc.model.Subjects;
import org.jcc.model.Teacher;
import org.jcc.service.StudentService;
import org.jcc.service.TeacherService;
import org.jcc.util.BorderLine;

import java.util.Scanner;

public class TeacherController {

    private final TeacherService teacherService;
    private final StudentService studentService;

    private static final Scanner input = new Scanner(System.in);

    public TeacherController(TeacherService teacherService, StudentService studentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    // Register Student
    public void registerStudentInSubject(Teacher teacher) {
        while (true) {
            if (teacher == null) {
                System.out.println("Teacher not found!");
                return;
            }

            BorderLine.titleMenu("REGISTER STUDENTS");

            System.out.print("|| SEARCH STUDENT ID: ");
            String studentId = input.nextLine();

            if (studentId.equals("0")) {break;}

            // Get the existing student from the shared repository
            Student student = studentService.searchStudentById(studentId);

            if (student == null) {
                BorderLine.displayFeedback("Student not found!");
                return;
            }

            String fullName =student.getFirstName() + " " + student.getLastName();
            System.out.printf("|| STUDENT NAME: %-96s ||", fullName);

            if (teacher.getSubjects().isEmpty()) {
                BorderLine.displayFeedback("Teacher has no subjects!");
                return;
            }

            System.out.println();
            BorderLine.displayChoice("0) CANCEL REGISTER     1) REGISTER ALL SUBJECT TO STUDENT     OPTIONAL(INPUT SUBJECT ID) TO REGISTER 1 SUBJECT", 0);

            System.out.print("|| CHOOSE HOW TO REGISTER: ");
            String choice = input.nextLine();

            if (choice.equals("0")) {
                BorderLine.displayFeedback("Registration Cancelled!");
                return;
            }

            // Register in all teacher subjects
            if (choice.equals("1")) {
                int registeredCount = teacherService.registerStudentInAllSubjects(teacher, student);

                if (registeredCount > 0) {
                    System.out.println("Student registered in " + registeredCount + " subject(s) successfully!");
                } else {
                    System.out.println("No subjects were registered.");
                }
                return;
            }

            // Register in one specific subject
            boolean registered = teacherService.registerStudentInSpecificSubject(teacher, student, choice);

            if (registered) {
                BorderLine.displayFeedback("Student registered in " + registered + " subject(s) successfully!");
            } else {
                System.out.println("Registration failed! Check the Subject ID.");
            }
        }
    }


    // Display Teacher's Students
    public void displayTeacherStudents(Teacher teacher) {
        BorderLine.titleMenu("STUDENT LISTS");
        System.out.printf("|| %-23s || %-20s || %-10s || %-10s || %-10s || %-14s || \n", "Name", "Subject Name", "1st Grading", "2nd Grading", "3rd Grading", "4th Grading");
        BorderLine.borderLine();
        for (Student student : teacher.getStudents()) {
            String fullName = student.getFirstName() + " " + student.getMiddleName() + " " + student.getLastName();
            for (Subjects subject : student.getSubjects()) {
                // Check if the subject is registered by this teacher
                Subjects teacherSubject = teacher.getSubjectById(subject.getSubjectId());
                if (teacherSubject != null) {
                    System.out.printf("|| %-23s || %-20s || %-11s || %-11s || %-11s || %-14s || \n", fullName, subject.getSubjectName(), subject.getFirstGrading(), subject.getSecondGrading(), subject.getThirdGrading(), subject.getFourthGrading());
                }
            }
        }
    }


    // Register Subject
    public void registerSubject(Teacher teacher) {
        if (teacher == null) {
            System.out.println("Teacher not found!");
            return;
        }

        System.out.print("|| Enter Subject ID: ");
        String subjectId = input.nextLine();
        System.out.print("|| Enter Subject Name: ");
        String subjectName = input.nextLine();

        Subjects subject = new Subjects(subjectId, subjectName, 0.0, 0.0, 0.0, 0.0);

        boolean registered = teacherService.registerSubject(teacher.getTeacherId(), subject
        );

        if (registered) {
            System.out.println("Subject registered successfully!");
        } else {
            System.out.println("Subject registration failed!");
            System.out.println("Subject ID may already exist.");
        }
    }


    // Update Student Grade
    public void updateStudentGrade(Teacher teacher) {
        BorderLine.titleMenu("UPDATE STUDENT GRADES");

        // Ask for Student ID
        System.out.print("|| STUDENT ID: ");
        String studentId = input.nextLine();

        // Search for student
        Student student = studentService.searchStudentById(studentId);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        // Display student information
        System.out.println("|| STUDENT INFORMATION: " + student.getId() + " " + student.getFirstName() + " " + student.getLastName());
        // Display teacher's subjects
        System.out.print("|| Your Subjects:");

        for (Subjects subject : teacher.getSubjects()) {
            System.out.print(subject.getSubjectId() + " " + subject.getSubjectName() + " ");
        }

        // Ask for Subject ID
        System.out.print("\n|| SUBJECT ID: ");
        String subjectId = input.nextLine();

        // Ask for grading period
        BorderLine.displayChoice("1) FIRST GRADING     2) SECOND GRADING     3) THIRD GRADING     4) FOURTH GRADING", 30);

        System.out.print("|| ENTER GRADING: ");
        int gradingPeriod = input.nextInt();

        // Ask for grade
        System.out.print("|| ENTER GRADE: ");
        double grade = input.nextDouble();
        input.nextLine();

        // Update grade
        boolean updated = teacherService.updateStudentGrade(teacher.getTeacherId(), studentId, student, subjectId, gradingPeriod, grade);

        if (updated) {
            BorderLine.displayFeedback("Student grade updated successfully!");
        } else {
            BorderLine.displayFeedback("Student grade update failed!");
            BorderLine.displayFeedback("Check the Student ID, Subject ID, and grading period.");
        }
    }
}
