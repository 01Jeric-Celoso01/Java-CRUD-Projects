package org.jcc.implement;

import org.jcc.model.Subjects;
import org.jcc.repository.SubjectsRepository;

import java.util.ArrayList;
import java.util.List;

public class SubjectsRepositoryImp implements SubjectsRepository {

    private final List<Subjects> subjects = new ArrayList<>();

    @Override
    public Subjects createSubject(Subjects subject) {
        subjects.add(subject);
        return subject;
    }

    @Override
    public List<Subjects> getAllSubjects() {
        return subjects;
    }

    @Override
    public Subjects getSubjectById(String subjectId) {
        for (Subjects subject : subjects) {
            if (subject.getSubjectId().equals(subjectId)) {
                return subject;
            }
        }
        return null;
    }

    @Override
    public Subjects updateSubject(String subjectId) {
        return getSubjectById(subjectId);
    }

    @Override
    public boolean deleteSubject(String subjectId) {
        Subjects subject = getSubjectById(subjectId);

        if (subject != null) {
            subjects.remove(subject);
            return true;
        }

        return false;
    }
}
