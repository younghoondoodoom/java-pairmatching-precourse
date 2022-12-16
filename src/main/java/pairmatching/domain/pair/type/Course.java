package pairmatching.domain.pair.type;

import java.util.Arrays;
import pairmatching.domain.pair.exception.NoSuchCourseException;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Course findByName(String name) {
        return Arrays.stream(Course.values()).filter(course -> course.name.equals(name)).findFirst()
            .orElseThrow(NoSuchCourseException::new);
    }
}
