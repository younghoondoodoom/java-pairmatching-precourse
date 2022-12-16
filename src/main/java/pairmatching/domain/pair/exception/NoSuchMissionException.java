package pairmatching.domain.pair.exception;

import pairmatching.domain.pair.exception.errorcode.PairErrorCode;

public class NoSuchMissionException extends PairException {

    public NoSuchMissionException() {
        super(PairErrorCode.NO_SUCH_MISSION);
    }
}
