package org.jcc.util;

import java.util.List;

public class GenerateStudentSubjects {

    public static List<String> generateSubjects(int gradeLevel) {
        switch (gradeLevel) {
            case 1:
                return List.of(
                        "English",
                        "Mathematics",
                        "Filipino",
                        "Science",
                        "Araling Panlipunan",
                        "MAPEH",
                        "GMRC"
                );
            case 2:
                return List.of(
                        "English",
                        "Mathematics",
                        "Filipino",
                        "Science",
                        "Araling Panlipunan",
                        "MAPEH",
                        "GMRC"
                );
            case 3:
                return List.of(
                        "English",
                        "Mathematics",
                        "Filipino",
                        "Science",
                        "Araling Panlipunan",
                        "MAPEH",
                        "TLE",
                        "Values Education"
                );

            default:
                return List.of();
        }
    }
}
