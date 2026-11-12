package org.jcc.model;

import org.jcc.enums.AccountRole;
import org.jcc.util.BorderLine;

import java.util.List;

public class Admin {

    private String adminId;
    private String adminName;
    private AccountRole role;

    public Admin(String adminId, String adminName) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.role = AccountRole.ADMIN;
    }

    // GETTERS
    public String getAdminId() {
        return adminId;
    }
    public String getAdminName() {
        return adminName;
    }

    // ADMIN INFORMATION
    public void displayAdminInfo() {
        BorderLine.borderLine();
        BorderLine.titleMenu("ADMIN INFORMATION");
        System.out.printf("|| ADMIN ID: %-30s || ADMIN NAME: %-54s ||%n", adminId, adminName);
        BorderLine.borderLine();
    }

    // DISPLAY ALL STUDENTS
    public void displayAllStudents(List<Student> students) {

        BorderLine.borderLine();
        BorderLine.titleMenu("ALL REGISTERED STUDENTS");

        if (students == null || students.isEmpty()) {
            System.out.println("|| No students registered.                                                                            ||");
        } else {
            System.out.println("|| TOTAL STUDENTS: " + students.size() + "                                                                                              ||");

            for (Student student : students) {
                student.displayInfo();
            }
        }
        BorderLine.borderLine();
    }

    // DISPLAY ALL TEACHERS
    public void displayAllTeachers(List<Teacher> teachers) {

        BorderLine.borderLine();
        BorderLine.titleMenu("|| ALL REGISTERED TEACHERS");

        if (teachers == null || teachers.isEmpty()) {
            System.out.println("|| No teachers registered.                                                                            ||");
        } else {

            System.out.println("|| TOTAL TEACHERS: " + teachers.size());

            for (Teacher teacher : teachers) {
                teacher.displayTeacherInfo();
            }
        }

        BorderLine.borderLine();
    }

    // DISPLAY SPECIFIC STUDENT
    public void displayStudent(Student student) {

        if (student == null) {
            System.out.println("|| Student not found!");
            return;
        }

        student.displayInfo();
    }

    public AccountRole getRole() {
        return role;
    }

    // DISPLAY SPECIFIC TEACHER
    public void displayTeacher(Teacher teacher) {

        if (teacher == null) {
            System.out.println("|| Teacher not found!");
            return;
        }

        teacher.displayTeacherInfo();
    }
}