package org.jcc.service;

import org.jcc.implement.CourseImpRepository;
import org.jcc.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseService {

    private final CourseImpRepository courseImplement;

    public CourseService(CourseImpRepository courseImplement) {
        this.courseImplement = courseImplement;
    }

    public boolean create(Course c) {
        return courseImplement.create(c);
    }

    public List<Course> viewAll() {
        return new ArrayList<>(courseImplement.viewAll());
    }

    public Course findById(String id) {
        return courseImplement.findById(id);
    }

    public Course update(String id) {
        return courseImplement.update(id);
    }

    public boolean delete(String id) {
        return courseImplement.delete(id);
    }
}
