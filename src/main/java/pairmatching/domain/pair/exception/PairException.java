package pairmatching.domain.pair.exception;

import pairmatching.domain.pair.exception.errorcode.PairErrorCode;

public class PairException extends IllegalArgumentException {

    private final PairErrorCode errorCode;

    protected PairException(PairErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
