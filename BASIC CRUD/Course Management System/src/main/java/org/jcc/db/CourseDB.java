package org.jcc.db;

import org.jcc.enums.CourseStatus;
import org.jcc.model.Course;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CourseDB {
    static List<Course> courses = new ArrayList<>();

    public static List<Course> data() {

        if (courses.isEmpty()) {

            Course c1 = new Course(
                    "CRS-001",
                    "BSCS",
                    "Bachelor of Science in Computer Science",
                    "Study of computer science and software development",
                    "UNDERGRADUATE",
                    4,
                    new BigDecimal("45000.00"),
                    160,
                    "Software Engineering",
                    CourseStatus.ACTIVE,
                    LocalDateTime.of(2026, 11, 14, 9, 0),
                    LocalDateTime.of(2026, 11, 14, 9, 0)
            );

            Course c2 = new Course(
                    "CRS-002",
                    "BSIT",
                    "Bachelor of Science in Information Technology",
                    "Study of information systems and technology",
                    "UNDERGRADUATE",
                    4,
                    new BigDecimal("42000.00"),
                    160,
                    "Web Development",
                    CourseStatus.ACTIVE,
                    LocalDateTime.of(2026, 11, 14, 9, 0),
                    LocalDateTime.of(2026, 11, 14, 9, 0)
            );

            Course c3 = new Course(
                    "CRS-003",
                    "BSBA",
                    "Bachelor of Science in Business Administration",
                    "Study of business operations and management",
                    "UNDERGRADUATE",
                    4,
                    new BigDecimal("38000.00"),
                    150,
                    "Marketing Management",
                    CourseStatus.ACTIVE,
                    LocalDateTime.of(2026, 11, 14, 9, 0),
                    LocalDateTime.of(2026, 11, 14, 9, 0)
            );

            Course c4 = new Course(
                    "CRS-004",
                    "BSHM",
                    "Bachelor of Science in Hospitality Management",
                    "Study of hospitality and tourism management",
                    "UNDERGRADUATE",
                    4,
                    new BigDecimal("40000.00"),
                    155,
                    "Hotel Management",
                    CourseStatus.ACTIVE,
                    LocalDateTime.of(2026, 11, 14, 9, 0),
                    LocalDateTime.of(2026, 11, 14, 9, 0)
            );

            Course c5 = new Course(
                    "CRS-005",
                    "BSED",
                    "Bachelor of Secondary Education",
                    "Study of teaching and educational practices",
                    "UNDERGRADUATE",
                    4,
                    new BigDecimal("35000.00"),
                    150,
                    "English",
                    CourseStatus.INACTIVE,
                    LocalDateTime.of(2026, 11, 14, 9, 0),
                    LocalDateTime.of(2026, 11, 14, 9, 0)
            );

            courses.add(c1);
            courses.add(c2);
            courses.add(c3);
            courses.add(c4);
            courses.add(c5);
        }

        return courses;
    }
}
