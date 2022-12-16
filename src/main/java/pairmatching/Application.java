package pairmatching;

import java.io.IOException;
import pairmatching.domain.config.PairConfig;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        try {
            PairConfig.config().run();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
