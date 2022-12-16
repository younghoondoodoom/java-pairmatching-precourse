package pairmatching.domain.pair.repository;

import java.util.List;
import java.util.Optional;
import pairmatching.domain.pair.model.Pair;
import pairmatching.domain.pair.model.PairInformation;

public interface PairRepository {

    Optional<List<Pair>> findByPairInformation(PairInformation pairInformation);
}
