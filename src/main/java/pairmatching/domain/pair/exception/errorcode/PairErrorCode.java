package pairmatching.domain.pair.exception.errorcode;

public enum PairErrorCode {

    PAIR_ALREADY_EXIST("해당 페어는 이미 존재합니다."),
    ALREADY_PAIRED_SAME_LEVEL("해당 레벨에서 이미 페어한 기록이 있습니다."),
    PAIR_NOT_FOUND("매칭 이력이 없습니다.");

    private final String message;

    PairErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
