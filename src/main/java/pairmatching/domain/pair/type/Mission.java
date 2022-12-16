package pairmatching.domain.pair.type;

import java.util.Arrays;
import pairmatching.domain.pair.exception.NoSuchLevelException;
import pairmatching.domain.pair.exception.NoSuchMissionException;

public enum Mission {

    CAR_RACE(Level.LEVEL1, "자동차경주"),
    LOTTO(Level.LEVEL1, "로또"),
    NUMBER_BASEBALL(Level.LEVEL1, "숫자야구게임"),
    SHOPPING_BASKET(Level.LEVEL2, "장바구니"),
    PAY(Level.LEVEL2, "결제"),
    SUBWAY_MAP(Level.LEVEL2, "지하철노선도"),
    PERFORMANCE_TUNING(Level.LEVEL4, "성능개선"),
    DEPLOY(Level.LEVEL4, "배포");

    private final Level level;
    private final String name;

    Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public Level getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public static Mission findByName(String name) {
        return Arrays.stream(Mission.values()).filter(mission -> mission.name.equals(name)).findFirst()
            .orElseThrow(NoSuchMissionException::new);
    }
}
