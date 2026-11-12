package org.jcc.service;

import org.jcc.implement.SubjectsRepositoryImp;
import org.jcc.model.Subjects;
import org.jcc.repository.SubjectsRepository;

import java.util.List;

public class SubjectsService {

    private final SubjectsRepository subjectRepository;

    public SubjectsService() {
        this.subjectRepository = new SubjectsRepositoryImp();
    }

    public Subjects createSubject(Subjects subject) {
        if (subjectRepository.getSubjectById(subject.getSubjectId()) != null) {
            return null;
        }

        return subjectRepository.createSubject(subject);
    }

    public List<Subjects> getAllSubjects() {
        return subjectRepository.getAllSubjects();
    }

    public Subjects getSubjectById(String subjectId) {
        return subjectRepository.getSubjectById(subjectId);
    }

    public Subjects updateSubject(String subjectId, Subjects updatedSubject) {
        Subjects existingSubject =
                subjectRepository.updateSubject(subjectId);

        if (existingSubject == null) {
            return null;
        }

        existingSubject.setSubjectName(updatedSubject.getSubjectName());
        existingSubject.setFirstGrading(updatedSubject.getFirstGrading());
        existingSubject.setSecondGrading(updatedSubject.getSecondGrading());
        existingSubject.setThirdGrading(updatedSubject.getThirdGrading());
        existingSubject.setFourthGrading(updatedSubject.getFourthGrading());

        return existingSubject;
    }

    public boolean deleteSubject(String subjectId) {
        return subjectRepository.deleteSubject(subjectId);
    }
}
