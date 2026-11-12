package org.jcc.controller;

import org.jcc.model.Subjects;
import org.jcc.service.SubjectsService;

import java.util.List;
import java.util.Scanner;

public class SubjectsController {

    private final SubjectsService subjectsService;
    private final Scanner input = new Scanner(System.in);

    public SubjectsController() {
        this.subjectsService = new SubjectsService();
    }

    // CREATE
    public void addSubjects() {
        System.out.print("Enter Subject ID: ");
        String subjectId = input.nextLine();
        System.out.print("Enter Subject Name: ");
        String subjectName = input.nextLine();
        System.out.print("Enter First Grading: ");
        double firstGrading = Double.parseDouble(input.nextLine());
        System.out.print("Enter Second Grading: ");
        double secondGrading = Double.parseDouble(input.nextLine());
        System.out.print("Enter Third Grading: ");
        double thirdGrading = Double.parseDouble(input.nextLine());
        System.out.print("Enter Fourth Grading: ");
        double fourthGrading = Double.parseDouble(input.nextLine());

        Subjects subject = new Subjects(subjectId, subjectName, firstGrading, secondGrading, thirdGrading, fourthGrading);

        Subjects savedSubject = subjectsService.createSubject(subject);

        if (savedSubject != null) {
            System.out.println("Subject added successfully!");
        } else {
            System.out.println("Subject ID already exists!");
        }
    }

    // READ ALL
    public void displayAllSubjects() {
        List<Subjects> subjectsList = subjectsService.getAllSubjects();

        if (subjectsList.isEmpty()) {
            System.out.println("No subjects found.");
            return;
        }

        System.out.printf("%-15s %-25s %10s %10s %10s %10s %10s%n", "Subject ID", "Subject Name", "1st Grade", "2nd Grade", "3rd Grade", "4th Grade", "Average");

        System.out.println("---------------------------------------------------------------------------------------------");

        for (Subjects subject : subjectsList) {
            System.out.printf("%-15s %-25s %10.2f %10.2f %10.2f %10.2f %10.2f%n", subject.getSubjectId(), subject.getSubjectName(), subject.getFirstGrading(), subject.getSecondGrading(), subject.getThirdGrading(), subject.getFourthGrading(), subject.getAverage());
        }
    }

    // READ ONE
    public void displaySubjectById() {
        System.out.print("Enter Subject ID: ");
        String subjectId = input.nextLine();

        Subjects subject = subjectsService.getSubjectById(subjectId);

        if (subject == null) {
            System.out.println("Subject not found.");
            return;
        }

        System.out.println("\n--- Subject Information ---");
        System.out.println("Subject ID: " + subject.getSubjectId());
        System.out.println("Subject Name: " + subject.getSubjectName());
        System.out.println("First Grading: " + subject.getFirstGrading());
        System.out.println("Second Grading: " + subject.getSecondGrading());
        System.out.println("Third Grading: " + subject.getThirdGrading());
        System.out.println("Fourth Grading: " + subject.getFourthGrading());
        System.out.printf("Average: %.2f%n", subject.getAverage());
    }

    // UPDATE
    public void updateSubjects() {
        System.out.print("Enter Subject ID to update: ");
        String subjectId = input.nextLine();

        Subjects existingSubject =
                subjectsService.getSubjectById(subjectId);

        if (existingSubject == null) {
            System.out.println("Subject not found.");
            return;
        }

        System.out.print("Enter New Subject Name: ");
        String subjectName = input.nextLine();
        System.out.print("Enter New First Grading: ");
        double firstGrading = Double.parseDouble(input.nextLine());
        System.out.print("Enter New Second Grading: ");
        double secondGrading = Double.parseDouble(input.nextLine());
        System.out.print("Enter New Third Grading: ");
        double thirdGrading = Double.parseDouble(input.nextLine());
        System.out.print("Enter New Fourth Grading: ");
        double fourthGrading = Double.parseDouble(input.nextLine());

        Subjects updatedSubject = new Subjects(subjectId, subjectName, firstGrading, secondGrading, thirdGrading, fourthGrading);

        Subjects result = subjectsService.updateSubject(subjectId, updatedSubject);

        if (result != null) {
            System.out.println("Subject updated successfully!");
        } else {
            System.out.println("Failed to update subject.");
        }
    }

    // DELETE
    public void deleteSubjects() {
        System.out.print("Enter Subject ID to delete: ");
        String subjectId = input.nextLine();

        boolean deleted = subjectsService.deleteSubject(subjectId);

        if (deleted) {
            System.out.println("Subject deleted successfully!");
        } else {
            System.out.println("Subject not found.");
        }
    }
}