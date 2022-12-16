package pairmatching.domain.pair.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.domain.pair.type.Course;
import pairmatching.domain.pair.type.Level;

public class Crew {

    private Course course;
    private String name;
    private Map<Level, List<Crew>> levelHistory = new HashMap<>();

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addLevelHistory(Crew crew, Level level) {
        if (levelHistory.containsKey(level)) {
            levelHistory.get(level).add(crew);
            return;
        }
        List<Crew> value = new ArrayList<>();
        value.add(crew);
        levelHistory.put(level, value);
    }

    public boolean isExistInSameLevel(Crew crew, Level level) {
        for (Crew history : levelHistory.getOrDefault(level, Collections.emptyList())) {
            if (history.equals(crew)) {
                return true;
            }
        }
        return false;
    }
}
