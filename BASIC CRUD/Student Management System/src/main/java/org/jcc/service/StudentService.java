
package org.jcc.service;

import org.jcc.model.Student;
import org.jcc.repository.StudentRepository;
import org.jcc.util.GenerateStudentId;

import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Create Student
    public Student createStudents(Student student) {

        if (student == null) { return null; }

        student.setId(GenerateStudentId.generateStudentId());

        return studentRepository.createStudent(student);
    }

    // Display All Students
    public List<Student> displayAllStudents() {
        return studentRepository.getAllStudents();
    }

    // Search Student by ID
    public Student searchStudentById(String id) {

        if (id == null || id.isBlank()) { return null; }

        return studentRepository.getStudentById(id);
    }

    // Update Student by ID
    public Student updateStudentById(String id) {

        if (id == null || id.isBlank()) { return null; }

        return studentRepository.updateStudent(id);
    }

    // Delete Student by ID
    public String deleteStudentById(String id) {

        if (id == null || id.isBlank()) {
            return "Invalid Student ID!";
        }

        return studentRepository.deleteStudent(id);
    }
}
