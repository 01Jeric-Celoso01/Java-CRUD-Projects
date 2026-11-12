package org.jcc.data;

import org.jcc.model.Teacher;
import org.jcc.model.Subjects;

import java.util.ArrayList;
import java.util.List;

public class TeacherSampleData {

    public static List<Teacher> addSampleTeachers() {

        List<Teacher> teachers = new ArrayList<>();


        // SAMPLE TEACHER 1
        Teacher teacher1 = new Teacher("985264731564", "John Smith", 2);

        // SAMPLE TEACHING SUBJECT
        teacher1.registerSubject(new Subjects("SUB-001", "Mathematics", 0, 0, 0, 0));
        teacher1.registerSubject(new Subjects("SUB-002", "Science", 0, 0, 0, 0));
        teachers.add(teacher1);


        // SAMPLE TEACHER 2
        Teacher teacher2 = new Teacher("694287614958", "Maria Santos", 1);

        // SAMPLE TEACHING SUBJECT
        teacher2.registerSubject(new Subjects("SUB-003", "English", 0, 0, 0, 0));
        teacher2.registerSubject(new Subjects("SUB-004", "Filipino", 0, 0, 0, 0));
        teachers.add(teacher2);


        // SAMPLE TEACHER 3
        Teacher teacher3 = new Teacher("497851632486", "Robert Cruz", 3);

        // SAMPLE TEACHING SUBJECT
        teacher3.registerSubject(new Subjects("SUB-005", "Programming", 0, 0, 0, 0));
        teacher3.registerSubject(new Subjects("SUB-006", "Computer Systems", 0, 0, 0, 0));
        teachers.add(teacher3);

        // RETURN THE LIST OF TEACHERS
        return teachers;
    }
}