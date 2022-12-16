package pairmatching.domain.pair.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.pair.exception.AlreadyPairedSameLevelException;
import pairmatching.domain.pair.exception.PairAlreadyExistException;
import pairmatching.domain.pair.exception.PairNotFoundException;
import pairmatching.domain.pair.model.Crew;
import pairmatching.domain.pair.model.Pair;
import pairmatching.domain.pair.model.PairInformation;
import pairmatching.domain.pair.repository.PairRepository;
import pairmatching.domain.pair.type.Level;

public class PairServiceImpl implements PairService {

    private final PairRepository pairRepository;

    public PairServiceImpl(PairRepository pairRepository) {
        this.pairRepository = pairRepository;
    }

    @Override
    public List<Pair> match(List<Crew> crews, PairInformation pairInformation) throws PairAlreadyExistException {
        if (pairRepository.findByPairInformation(pairInformation).isPresent()) {
            throw new PairAlreadyExistException();
        }
        List<Pair> pairs = tryGetPairs(crews, pairInformation.getLevel());
        return pairRepository.save(pairs, pairInformation);
    }

    @Override
    public List<Pair> reMatch(List<Crew> crews, PairInformation pairInformation) {
        pairRepository.removeByPairInformation(pairInformation);
        List<Pair> pairs = tryGetPairs(crews, pairInformation.getLevel());
        return pairRepository.save(pairs, pairInformation);
    }

    @Override
    public List<Pair> findPairs(PairInformation pairInformation) {
        return pairRepository.findByPairInformation(pairInformation)
            .orElseThrow(PairNotFoundException::new);
    }

    @Override
    public void init() {
        pairRepository.init();
    }


    private List<Pair> tryGetPairs(List<Crew> crews, Level level) {
        int count = 0;
        while (count <= 3) {
            try {
                return getPairs(crews, level);
            } catch (AlreadyPairedSameLevelException e) {
                count++;
            }
        }
        throw new AlreadyPairedSameLevelException();
    }

    private List<Pair> getPairs(List<Crew> crews, Level level) {
        List<Crew> shuffledCrews = Randoms.shuffle(crews);
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < shuffledCrews.size() - 1; i++) {
            if (shuffledCrews.size() % 2 == 1 && i == shuffledCrews.size() - 3) {
                pairs.add(makePair(level, shuffledCrews.get(i), shuffledCrews.get(i + 1), shuffledCrews.get(i + 2)));
            }
            pairs.add(makePair(level, shuffledCrews.get(i), shuffledCrews.get(i + 1)));
        }
        return pairs;
    }

    private Pair makePair(Level level, Crew... crews) {
        for (int i = 0; i < crews.length; i++) {
            for (int j = 0; j < crews.length; j++) {
                if (i == j) {
                    continue;
                }
                if (crews[i].isExistInSameLevel(crews[j], level)) {
                    throw new AlreadyPairedSameLevelException();
                }
            }
        }
        return Pair.makePair(level, crews);
    }
}
