package pairmatching.domain.pair.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import pairmatching.domain.pair.model.Pair;
import pairmatching.domain.pair.model.PairInformation;

public class PairRepositoryImpl implements PairRepository {

    private static PairRepositoryImpl instance;
    private Map<PairInformation, List<Pair>> pairDatabase;

    private PairRepositoryImpl() {
        pairDatabase = new HashMap<>();
    }

    public static synchronized PairRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new PairRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Optional<List<Pair>> findByPairInformation(PairInformation pairInformation) {
        List<Pair> pairs = pairDatabase.getOrDefault(pairInformation, null);
        if (pairs == null) {
            return Optional.empty();
        }
        return Optional.of(pairs);
    }

    @Override
    public void removeByPairInformation(PairInformation pairInformation) {
        try {
            pairDatabase.remove(pairInformation);
        } catch (NullPointerException ignored) {}
    }

    @Override
    public List<Pair> save(List<Pair> pairs, PairInformation pairInformation) {
        pairDatabase.put(pairInformation, pairs);
        return pairs;
    }

    @Override
    public void init() {
        pairDatabase = new HashMap<>();
    }

}
