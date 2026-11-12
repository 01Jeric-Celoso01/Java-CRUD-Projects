
package org.jcc.implement;

import org.jcc.data.TeacherSampleData;
import org.jcc.model.Teacher;
import org.jcc.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepositoryImp implements TeacherRepository {

    private final List<Teacher> teachers =
            new ArrayList<>(TeacherSampleData.addSampleTeachers());

    @Override
    public Teacher createTeacher(Teacher teacher) {

        if (teacher == null) {
            return null;
        }

        teachers.add(teacher);

        return teacher;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    @Override
    public Teacher getTeacherById(String teacherId) {

        if (teacherId == null) {
            return null;
        }

        for (Teacher teacher : teachers) {

            if (teacher.getTeacherId().equalsIgnoreCase(teacherId)) {
                return teacher;
            }
        }

        return null;
    }

    @Override
    public Teacher updateTeacher(String teacherId) {
        return getTeacherById(teacherId);
    }

    @Override
    public boolean deleteTeacher(String teacherId) {

        if (teacherId == null) {
            return false;
        }

        return teachers.removeIf(
                teacher -> teacher.getTeacherId().equalsIgnoreCase(teacherId)
        );
    }
}
