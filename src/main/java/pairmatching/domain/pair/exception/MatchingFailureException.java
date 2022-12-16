package pairmatching.domain.pair.exception;

import pairmatching.domain.pair.exception.errorcode.PairErrorCode;

public class MatchingFailureException extends PairException {

    public MatchingFailureException() {
        super(PairErrorCode.PAIR_FAILURE);
    }
}
