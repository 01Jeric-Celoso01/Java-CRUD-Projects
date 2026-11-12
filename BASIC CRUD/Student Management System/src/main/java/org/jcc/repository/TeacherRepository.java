
package org.jcc.repository;

import org.jcc.model.Teacher;

import java.util.List;

public interface TeacherRepository {

    Teacher createTeacher(Teacher teacher);
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(String teacherId);
    Teacher updateTeacher(String teacherId);
    boolean deleteTeacher(String teacherId);
}
