package pairmatching.domain.pair.validation.validator;

import pairmatching.domain.pair.dto.InputValidationRequest;
import pairmatching.domain.pair.dto.InputValidationResponse;
import pairmatching.domain.pair.type.ValidationType;
import pairmatching.domain.pair.validation.InputValidationChain;

public class PairInformationValidateChain implements InputValidationChain {

    private InputValidationChain next;
    private static final String INVALID_SPACE_MESSAGE = "띄어쓰기로 구분 해주세요";

    @Override
    public void setNext(InputValidationChain next) {
        this.next = next;
    }

    @Override
    public InputValidationResponse validate(InputValidationRequest request) {
        if (!request.getValidationTypes().contains(ValidationType.PAIR_INFORMATION)) {
            return next.validate(request);
        }
        if (request.getTarget().split(" ").length != 3) {
            return new InputValidationResponse(false, INVALID_SPACE_MESSAGE);
        }
        return next.validate(request);
    }
}
