package org.jcc.implement;

import org.jcc.db.CourseDB;
import org.jcc.model.Course;
import org.jcc.repository.CourseRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CourseImpRepository implements CourseRepository {
    private final List<Course> COURSES = new ArrayList<>(CourseDB.data());

    @Override
    public boolean create(Course c) {
        COURSES.add(c);
        return false;
    }

    @Override
    public List<Course> viewAll() {
        return new ArrayList<>(COURSES);
    }

    @Override
    public Course findById(String id) {
        for (Course c : COURSES) {
            if (c.getCourse_id().equals(id)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Course update(String id) {
        for (Course c : COURSES) {
            if (c.getCourse_id().equals(id)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Iterator<Course> iterator = COURSES.iterator();

        while (iterator.hasNext()) {
            Course c = iterator.next();

            if (c.getCourse_id().equals(id)) {
                return true;
            }
        }

        return false;
    }
}
