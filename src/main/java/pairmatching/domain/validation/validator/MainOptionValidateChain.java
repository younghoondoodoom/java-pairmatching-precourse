package pairmatching.domain.validation.validator;

import pairmatching.domain.pair.dto.InputValidationRequest;
import pairmatching.domain.pair.dto.InputValidationResponse;
import pairmatching.domain.pair.type.ValidationType;
import pairmatching.domain.validation.InputValidationChain;
import pairmatching.domain.validation.util.ValidateUtil;

public class MainOptionValidateChain implements InputValidationChain {

    private InputValidationChain next;
    private static final String[] EXPECTED_LETTER = new String[]{"1", "2", "3", "Q"};
    private static final String NOT_EXPECTED_LETTER_MESSAGE = "%s %s %s %s 중에 하나만 들어올 수 있습니다.";

    @Override
    public void setNext(InputValidationChain next) {
        this.next = next;
    }

    @Override
    public InputValidationResponse validate(InputValidationRequest request) {
        if (!request.getValidationTypes().contains(ValidationType.MAIN_OPTION)) {
            return next.validate(request);
        }
        if (!ValidateUtil.isExpectedLetter(request.getTarget(), EXPECTED_LETTER)) {
            return new InputValidationResponse(false,
                String.format(NOT_EXPECTED_LETTER_MESSAGE, (Object[]) EXPECTED_LETTER));
        }
        return next.validate(request);
    }
}
