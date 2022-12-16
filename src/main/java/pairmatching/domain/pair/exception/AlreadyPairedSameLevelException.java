package pairmatching.domain.pair.exception;

import pairmatching.domain.pair.exception.errorcode.PairErrorCode;

public class AlreadyPairedSameLevelException extends PairException {


    public AlreadyPairedSameLevelException() {
        super(PairErrorCode.ALREADY_PAIRED_SAME_LEVEL);
    }
}
