
package org.jcc.repository;

import org.jcc.model.Student;

import java.util.List;

public interface StudentRepository {

    Student createStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(String id);
    Student updateStudent(String id);
    String deleteStudent(String id);
}
