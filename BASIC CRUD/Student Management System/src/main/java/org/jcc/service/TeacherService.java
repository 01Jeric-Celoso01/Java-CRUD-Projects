
package org.jcc.service;

import org.jcc.implement.TeacherRepositoryImp;
import org.jcc.model.Student;
import org.jcc.model.Subjects;
import org.jcc.model.Teacher;
import org.jcc.repository.TeacherRepository;

import java.util.List;

public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService() {
        this.teacherRepository = new TeacherRepositoryImp();
    }

    // Create Teacher
    public Teacher createTeacher(Teacher teacher) {

        if (teacher == null) { return null; }

        if (teacherRepository.getTeacherById(
                teacher.getTeacherId()) != null) {
            return null;
        }

        return teacherRepository.createTeacher(teacher);
    }

    // Display All Teachers
    public List<Teacher> getAllTeachers() {
        return teacherRepository.getAllTeachers();
    }

    // Search Teacher by ID
    public Teacher getTeacherById(String teacherId) {
        return teacherRepository.getTeacherById(teacherId);
    }

    // Update Teacher
    public Teacher updateTeacher(String teacherId, String teacherName, int gradeLevel) {
        Teacher teacher = teacherRepository.updateTeacher(teacherId);

        if (teacher == null) {return null; }

        teacher.setTeacherName(teacherName);
        teacher.setGradeLevel(gradeLevel);

        return teacher;
    }

    // Delete Teacher
    public boolean deleteTeacher(String teacherId) {
        return teacherRepository.deleteTeacher(teacherId);
    }

    // Register Subject
    public boolean registerSubject(String teacherId, Subjects subject) {
        Teacher teacher = teacherRepository.getTeacherById(teacherId);

        if (teacher == null || subject == null) { return false; }

        return teacher.registerSubject(subject);
    }

    // Register Student in One Subject
    public boolean registerStudentInSpecificSubject(Teacher teacher, Student student, String subjectId) {

        if (teacher == null || student == null || subjectId == null) {return false; }

        // Verify that the teacher handles this subject
        Subjects subject = teacher.getSubjectById(subjectId);

        if (subject == null) { return false; }

        // Add the subject to the student's subject list
        return teacher.registerStudentInSubject(student, subjectId);
    }

    // Register Student in All Teacher Subjects
    public int registerStudentInAllSubjects(Teacher teacher,  Student student) {

        if (teacher == null || student == null) { return 0;}
        if (teacher.getSubjects().isEmpty()) { return 0; }

        int registeredCount = 0;

        for (Subjects subject : teacher.getSubjects()) {
            boolean registered = registerStudentInSpecificSubject(teacher, student, subject.getSubjectId());

            if (registered) { registeredCount++; }
        }

        return registeredCount;
    }

    // Update Student Grade
    public boolean updateStudentGrade(String teacherId, String studentId, Student student, String subjectId, int gradingPeriod, double grade) {

        Teacher teacher = teacherRepository.getTeacherById(teacherId);

        if (teacher == null || student == null) { return false; }

        if (!student.getId().equals(studentId)) { return false; }

        return teacher.updateStudentGrade(studentId, subjectId, gradingPeriod, grade);
    }
}