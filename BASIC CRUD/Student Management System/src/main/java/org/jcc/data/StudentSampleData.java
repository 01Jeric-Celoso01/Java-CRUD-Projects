package org.jcc.data;

import org.jcc.model.Student;
import org.jcc.model.Subjects;

import java.util.List;

public class StudentSampleData {

    public static List<Student> getSampleStudents() {

        // SAMPLE STUDENT 1
        Student student1 = new Student("Maria", "Santos", "Reyes", "Female", "03012001", "09181234567", "maria.reyes@email.com", 2);
        student1.setId("206801946058");

        // SAMPLE SUBJECT REGISTER TO STUDENT
        Subjects math = new Subjects("SUB-001", "Mathematics", 90, 92, 94, 96);
        Subjects english = new Subjects("SUB-003", "English", 88, 90, 92, 94);
        student1.addSubject(math);
        student1.addSubject(english);


        // SAMPLE STUDENT 2
        Student student2 = new Student("John", "Michael", "Cruz", "Male", "03011999", "09171234567", "john.cruz@email.com", 3);
        student2.setId("394600264801");

        // SAMPLE SUBJECT REGISTER TO STUDENT
        Subjects science = new Subjects("SUB-002", "Science", 85, 87, 89, 91);
        student2.addSubject(science);

        return List.of(student1, student2);
    }
}