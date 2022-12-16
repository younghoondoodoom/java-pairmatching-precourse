package pairmatching.domain.pair.exception;

import pairmatching.domain.pair.exception.errorcode.PairErrorCode;

public class PairNotFoundException extends PairException {

    public PairNotFoundException() {
        super(PairErrorCode.PAIR_NOT_FOUND);
    }
}
