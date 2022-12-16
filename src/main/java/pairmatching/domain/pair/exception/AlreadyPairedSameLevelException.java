package pairmatching.domain.pair.exception;

import pairmatching.domain.pair.exception.errorcode.PairErrorCode;

public class AlreadyPairedSameLevelException extends RuntimeException {

    private final PairErrorCode errorCode;

    public AlreadyPairedSameLevelException() {
        this.errorCode = PairErrorCode.ALREADY_PAIRED_SAME_LEVEL;
    }

    public PairErrorCode getErrorCode() {
        return errorCode;
    }
}
