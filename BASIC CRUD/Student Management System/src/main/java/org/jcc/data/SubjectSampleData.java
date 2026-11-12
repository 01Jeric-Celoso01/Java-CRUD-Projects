package org.jcc.data;

import org.jcc.model.Subjects;

import java.util.ArrayList;
import java.util.List;

public class SubjectSampleData {

    public static List<Subjects> getAllSubjects() {

        // SAMPLE LIST OF SUBJECTS
        List<Subjects> subjects = new ArrayList<>();

        subjects.add(new Subjects("SUB-001", "Mathematics", 0, 0, 0, 0));
        subjects.add(new Subjects("SUB-002", "Science", 0, 0, 0, 0));
        subjects.add(new Subjects("SUB-003", "English", 0, 0, 0, 0));
        subjects.add(new Subjects("SUB-004", "Filipino", 0, 0, 0, 0));
        subjects.add(new Subjects("SUB-005", "Programming", 0, 0, 0, 0));
        subjects.add(new Subjects("SUB-006", "Computer Systems", 0, 0, 0, 0));
        subjects.add(new Subjects("SUB-007", "History", 0, 0, 0, 0));
        subjects.add(new Subjects("SUB-008", "Social Studies", 0, 0, 0, 0));
        subjects.add(new Subjects("SUB-009", "Physics", 0, 0, 0, 0));
        subjects.add(new Subjects("SUB-010", "Chemistry", 0, 0, 0, 0));
        subjects.add(new Subjects("SUB-011", "Biology", 0, 0, 0, 0));
        subjects.add(new Subjects("SUB-012", "Physical Education", 0, 0, 0, 0));
        subjects.add(new Subjects("SUB-013", "Arts", 0, 0, 0, 0));
        subjects.add(new Subjects("SUB-014", "Music", 0, 0, 0, 0));
        subjects.add(new Subjects("SUB-015", "Economics", 0, 0, 0, 0));

        return subjects;
    }
}