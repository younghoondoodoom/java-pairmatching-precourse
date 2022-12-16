package pairmatching.domain.pair.type;

import java.util.Arrays;
import pairmatching.domain.pair.exception.NoSuchCourseException;
import pairmatching.domain.pair.exception.NoSuchLevelException;

public enum Level {

    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;

    Level(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Level findByName(String name) {
        return Arrays.stream(Level.values()).filter(level -> level.name.equals(name)).findFirst()
            .orElseThrow(NoSuchLevelException::new);
    }
}
