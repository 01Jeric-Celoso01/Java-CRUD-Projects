
package org.jcc.model;

import org.jcc.enums.AccountRole;
import org.jcc.util.BorderLine;
import org.jcc.util.GenerateAgeUsingBirthDay;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private int age;
    private String birthDate;
    private String number;
    private String email;
    private AccountRole role;
    private int gradeLevel;
    private double gpa;

    private List<Subjects> subjects = new ArrayList<>();

    public Student(String firstName, String middleName, String lastName, String gender, String birthDate, String number, String email, int gradeLevel) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = Math.toIntExact(GenerateAgeUsingBirthDay.generateAge(birthDate));
        this.birthDate = birthDate;
        this.number = number;
        this.role = AccountRole.STUDENT;
        this.email = email;
        this.gradeLevel = gradeLevel;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String fullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthDate() {
        if (birthDate == null || birthDate.length() != 8) {
            return birthDate;
        }

        return birthDate.substring(0, 2) + "/" + birthDate.substring(2, 4) + "/" + birthDate.substring(4, 8);
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;

        if (birthDate != null && birthDate.length() == 8) {
            this.age = Math.toIntExact(GenerateAgeUsingBirthDay.generateAge(birthDate));
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountRole getRole() {
        return role;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public double getGpa() {

        if (subjects.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;

        for (Subjects subject : subjects) {
            total += subject.getAverage();
        }

        return total / subjects.size();
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    // Add Subject
    public void addSubject(Subjects subject) {

        if (subject == null) {
            return;
        }

        // Prevent duplicate subject IDs
        for (Subjects existing : subjects) {

            if (existing.getSubjectId().equalsIgnoreCase(
                    subject.getSubjectId())) {

                return;
            }
        }

        subjects.add(subject);
    }

    // Get Student Subjects
    public List<Subjects> getSubjects() {
        return subjects;
    }

    // Display Student Information
    public void displayInfo() {
        BorderLine.borderLine();
        BorderLine.titleMenu("STUDENT INFORMATION");
        System.out.printf("|| FULL NAME: %-27s || STUDENT ID: %-20s || GPA: %-27.2f ||%n", fullName(), id, getGpa());
        System.out.printf("|| BIRTH DAY: %-27s || AGE: %-27d || GENDER: %-24s ||%n", getBirthDate(), age, gender);
        System.out.printf("|| NUMBER: %-30s || EMAIL: %-61s ||%n", number, email);
        BorderLine.borderLine();
    }

    // Display Student Subjects and Grades
    public void displaySubjectAndGrades() {
        System.out.printf("|| %-25s || %-14s || %-14s || %-14s || %-14s || %-9s ||%n", "LIST OF SUBJECTS", "1ST GRADING", "2ND GRADING", "3RD GRADING", "4TH GRADING", "Average");

        if (subjects.isEmpty()) {
            System.out.println("|| No subjects registered.");
        }

        for (Subjects subject : subjects) {
            System.out.printf("|| %-25s || %-14s || %-14s || %-14s || %-14s || %-9s ||%n", subject.getSubjectName(), subject.getFirstGrading(), subject.getSecondGrading(), subject.getThirdGrading(), subject.getFourthGrading(), subject.getAverage());
        }
        BorderLine.borderLine();
    }
}