package pairmatching.domain.pair.service;

import java.util.List;
import pairmatching.domain.pair.model.Crew;
import pairmatching.domain.pair.model.Pair;
import pairmatching.domain.pair.model.PairInformation;

public interface PairService {

    List<Pair> match(List<Crew> crews, PairInformation pairInformation);

    List<Pair> reMatch(List<Crew> crews, PairInformation pairInformation);
}
