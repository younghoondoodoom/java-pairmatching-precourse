package pairmatching.domain.validation.validator;

import pairmatching.domain.pair.dto.InputValidationRequest;
import pairmatching.domain.pair.dto.InputValidationResponse;
import pairmatching.domain.validation.InputValidationChain;

public class InputValidateSuccessChain implements InputValidationChain {

    @Override
    public void setNext(InputValidationChain next) {}

    @Override
    public InputValidationResponse validate(InputValidationRequest request) {
        return new InputValidationResponse(true);
    }
}
