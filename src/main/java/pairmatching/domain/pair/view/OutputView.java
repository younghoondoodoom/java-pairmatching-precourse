package pairmatching.domain.pair.view;

import java.util.List;
import pairmatching.domain.pair.model.Pair;

public class OutputView {

    public static void printDashBoard() {
        System.out.println("#############################################");
        System.out.println("과정: 백엔드 | 프론트엔드");
        System.out.println("미션:");
        System.out.println("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임");
        System.out.println("  - 레벨2: 장바구니 | 결제 | 지하철노선도");
        System.out.println("  - 레벨3:");
        System.out.println("  - 레벨4: 성능개선 | 배포");
        System.out.println("  - 레벨5:");
        System.out.println("#############################################");
    }

    public static void printPairResult(List<Pair> result) {
        System.out.println("페어 매칭 결과입니다.");
        for (Pair pair : result) {
            System.out.println(pair);
        }
    }

}
