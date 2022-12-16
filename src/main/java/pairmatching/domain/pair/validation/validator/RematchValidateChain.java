package pairmatching.domain.pair.validation.validator;

import pairmatching.domain.pair.dto.InputValidationRequest;
import pairmatching.domain.pair.dto.InputValidationResponse;
import pairmatching.domain.pair.type.ValidationType;
import pairmatching.domain.pair.validation.InputValidationChain;
import pairmatching.domain.pair.validation.util.ValidateUtil;

public class RematchValidateChain implements InputValidationChain {

    private InputValidationChain next;
    private static final String[] EXPECTED_LETTER = new String[]{"네", "아니오"};
    private static final String NOT_EXPECTED_LETTER_MESSAGE = "%s %s 중에 하나만 들어올 수 있습니다.";

    @Override
    public void setNext(InputValidationChain next) {
        this.next = next;
    }

    @Override
    public InputValidationResponse validate(InputValidationRequest request) {
        if (!request.getValidationTypes().contains(ValidationType.REMATCH)) {
            return next.validate(request);
        }
        if (!ValidateUtil.isExpectedLetter(request.getTarget(), EXPECTED_LETTER)) {
            return new InputValidationResponse(false,
                String.format(NOT_EXPECTED_LETTER_MESSAGE, (Object[]) EXPECTED_LETTER));
        }
        return next.validate(request);
    }
}
