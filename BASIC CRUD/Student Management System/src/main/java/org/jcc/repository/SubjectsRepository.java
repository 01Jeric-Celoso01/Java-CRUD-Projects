package org.jcc.repository;

import org.jcc.model.Subjects;
import java.util.List;

public interface SubjectsRepository {

    Subjects createSubject(Subjects subject);
    List<Subjects> getAllSubjects();
    Subjects getSubjectById(String subjectId);
    Subjects updateSubject(String subjectId);
    boolean deleteSubject(String subjectId);
}
