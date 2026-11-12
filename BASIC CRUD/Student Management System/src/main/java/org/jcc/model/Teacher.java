
package org.jcc.model;

import org.jcc.enums.AccountRole;
import org.jcc.util.BorderLine;

import java.util.ArrayList;
import java.util.List;

public class Teacher {

    private String teacherId;
    private String teacherName;
    private int gradeLevel;
    private AccountRole role;

    private List<Subjects> subjects = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public Teacher(String teacherId, String teacherName, int gradeLevel) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.gradeLevel = gradeLevel;
        this.role = AccountRole.TEACHER;
    }

    // Getters and Setters

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    // Register Subject

    public boolean registerSubject(Subjects subject) {

        if (subject == null || subject.getSubjectId() == null) {
            return false;
        }

        for (Subjects existing : subjects) {

            if (existing.getSubjectId().equalsIgnoreCase(
                    subject.getSubjectId())) {
                return false;
            }
        }

        subjects.add(subject);
        return true;
    }

    // Find Subject by ID

    public Subjects getSubjectById(String subjectId) {

        if (subjectId == null) {
            return null;
        }

        for (Subjects subject : subjects) {

            if (subject.getSubjectId().equalsIgnoreCase(subjectId)) {
                return subject;
            }
        }

        return null;
    }

    // Find Subject by Name

    public Subjects getSubjectByName(String subjectName) {

        if (subjectName == null) {
            return null;
        }

        for (Subjects subject : subjects) {

            if (subject.getSubjectName().equalsIgnoreCase(subjectName)) {
                return subject;
            }
        }

        return null;
    }

    // Register Student in Subject

    public boolean registerStudentInSubject(Student student, String subjectId) {

        if (student == null || subjectId == null) {
            return false;
        }

        // Check if the teacher handles this subject
        Subjects teacherSubject = getSubjectById(subjectId);

        if (teacherSubject == null) {
            return false;
        }

        // Check whether the student already has this subject
        boolean subjectAlreadyExists = false;

        for (Subjects studentSubject : student.getSubjects()) {

            if (studentSubject.getSubjectId().equalsIgnoreCase(subjectId)) {
                subjectAlreadyExists = true;
                break;
            }
        }

        // Add subject to the student's own subject list
        if (!subjectAlreadyExists) {
            Subjects studentSubject = new Subjects(teacherSubject.getSubjectId(), teacherSubject.getSubjectName(), 0.0, 0.0, 0.0, 0.0);
            student.addSubject(studentSubject);
        }

        // Add student to teacher's student list if not already present
        boolean studentAlreadyExists = false;

        for (Student existingStudent : students) {

            if (existingStudent.getId().equalsIgnoreCase(student.getId())) {
                studentAlreadyExists = true;
                break;
            }
        }

        if (!studentAlreadyExists) {
            students.add(student);
        }

        return true;
    }

    // Update Student Grade

    public boolean updateStudentGrade(String studentId, String subjectId, int gradingPeriod, double grade) {
        // Find the specific student
        Student student = null;

        for (Student s : students) {
            if (s.getId().equals(studentId)) {
                student = s;
                break;
            }
        }

        if (student == null) {
            return false;
        }

        // Find the subject assigned to this teacher
        Subjects teacherSubject = getSubjectById(subjectId);

        if (teacherSubject == null) {
            return false;
        }

        // Find the subject belonging to this student
        for (Subjects subject : student.getSubjects()) {

            if (subject.getSubjectId().equals(subjectId)) {

                switch (gradingPeriod) {
                    case 1:
                        subject.setFirstGrading(grade);
                        break;

                    case 2:
                        subject.setSecondGrading(grade);
                        break;

                    case 3:
                        subject.setThirdGrading(grade);
                        break;

                    case 4:
                        subject.setFourthGrading(grade);
                        break;

                    default:
                        return false;
                }

                return true;
            }
        }

        return false;
    }

    public AccountRole getRole() {
        return role;
    }

    // Display Teacher Information
    public void displayTeacherInfo() {
        BorderLine.borderLine();
        BorderLine.titleMenu("TEACHER INFORMATION");
        System.out.printf("|| Teacher Id: %-20s || Teacher Name: %-20s || Grade Level: %-23d ||%n", teacherId, teacherName, gradeLevel);
        System.out.printf("|| Total Subjects: %-16d || Total Students: %-58d ||%n", subjects.size(), students.size());
        System.out.print("|| SUBJECTS = ");

        if (subjects.isEmpty()) {
            System.out.print("No subjects registered.");
        } else {
            for (Subjects subject : subjects) {
                System.out.print("- " + subject.getSubjectName() + " (" + subject.getSubjectId() + ") ");
            }
        }
        System.out.println();
        BorderLine.borderLine();
    }
}
