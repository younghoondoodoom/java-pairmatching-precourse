package pairmatching.domain.pair.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import pairmatching.domain.pair.type.Level;

public class Pair {

    private final List<Crew> crews;

    public Pair(List<Crew> crews) {
        this.crews = crews;
    }

    public List<Crew> getCrews() {
        return crews;
    }

    public static Pair makePair(Level level, Crew... crews) {
        List<Crew> pair = new ArrayList<>();
        IntStream.range(0, crews.length).forEach(i -> {
            Crew crew = crews[i];
            addCrewLevelHistory(level, i, crew, crews);
            pair.add(crew);
        });
        return new Pair(pair);
    }

    private static void addCrewLevelHistory(Level level, int idx, Crew crew, Crew[] crews) {
        IntStream.range(0, crews.length).filter(j -> idx != j).forEach(j -> crew.addLevelHistory(crews[j], level));
    }
}
