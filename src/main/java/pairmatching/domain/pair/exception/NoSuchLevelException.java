package pairmatching.domain.pair.exception;

import pairmatching.domain.pair.exception.errorcode.PairErrorCode;

public class NoSuchLevelException extends PairException {

    public NoSuchLevelException() {
        super(PairErrorCode.NO_SUCH_LEVEL);
    }
}
