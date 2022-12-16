package pairmatching.domain.pair.exception;

import pairmatching.domain.pair.exception.errorcode.PairErrorCode;

public class PairAlreadyExistException extends PairException {

    public PairAlreadyExistException() {
        super(PairErrorCode.PAIR_ALREADY_EXIST);
    }
}
