package pairmatching.domain.pair.exception;

import pairmatching.domain.pair.exception.errorcode.PairErrorCode;

public class PairAlreadyExistException extends RuntimeException {

    private final PairErrorCode errorCode;

    public PairAlreadyExistException() {
        this.errorCode = PairErrorCode.PAIR_ALREADY_EXIST;
    }

    public PairErrorCode getErrorCode() {
        return errorCode;
    }
}
