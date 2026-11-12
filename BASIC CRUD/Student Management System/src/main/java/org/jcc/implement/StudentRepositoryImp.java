
package org.jcc.implement;

import org.jcc.data.StudentSampleData;
import org.jcc.model.Student;
import org.jcc.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImp implements StudentRepository {

    private final List<Student> students =
            new ArrayList<>(StudentSampleData.getSampleStudents());

    @Override
    public Student createStudent(Student student) {

        if (student == null) {
            return null;
        }

        students.add(student);

        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudentById(String id) {

        if (id == null) {
            return null;
        }

        for (Student student : students) {

            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }

        return null;
    }

    @Override
    public Student updateStudent(String id) {
        return getStudentById(id);
    }

    @Override
    public String deleteStudent(String id) {

        if (id == null) {
            return "Invalid Student ID!";
        }

        boolean deleted = students.removeIf(
                student -> student.getId().equalsIgnoreCase(id)
        );

        if (deleted) {
            return "Student with ID " + id + " has been deleted.";
        }

        return "Student not found!";
    }
}
