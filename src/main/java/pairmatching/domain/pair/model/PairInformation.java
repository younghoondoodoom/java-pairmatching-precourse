package pairmatching.domain.pair.model;

import java.util.Objects;
import pairmatching.domain.pair.type.Course;
import pairmatching.domain.pair.type.Level;
import pairmatching.domain.pair.type.Mission;

public class PairInformation {

    private final Course course;
    private final Level level;
    private final Mission mission;

    public PairInformation(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof PairInformation) {
            PairInformation aPairInformation = (PairInformation)anObject;
            return this.course.equals(aPairInformation.course)
                && this.level.equals(aPairInformation.level)
                && this.mission.equals(aPairInformation.mission);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourse(), getLevel(), getMission());
    }
}
