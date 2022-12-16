package pairmatching.domain.pair.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.domain.pair.type.Course;
import pairmatching.domain.pair.type.Level;

public class Crew {

    private Course course;
    private String name;
    private Map<Level, List<Crew>> levelHistory = new HashMap<>();

    public Crew(Course course, String name, Map<Level, List<Crew>> levelHistory) {
        this.course = course;
        this.name = name;
    }

    public void addLevelHistory(Crew crew, Level level) {
        if (levelHistory.containsKey(level)) {
            levelHistory.get(level).add(crew);
            return;
        }
        levelHistory.put(level, List.of(crew));
    }

    public boolean isExistInSameLevel(Crew crew, Level level) {
        for (Crew history : levelHistory.get(level)) {
            if (history.equals(crew)) {
                return false;
            }
        }
        return true;
    }
}
