package org.jcc.repository;

import org.jcc.model.Course;

import java.util.List;

public interface CourseRepository {
    boolean create(Course c);
    List<Course> viewAll();
    Course findById(String id);
    Course update(String id);
    boolean delete(String id);
}
