package pairmatching.domain.pair.exception;

import pairmatching.domain.pair.exception.errorcode.PairErrorCode;

public class NoSuchCourseException extends PairException {

    public NoSuchCourseException() {
        super(PairErrorCode.NO_SUCH_COURSE);
    }
}
