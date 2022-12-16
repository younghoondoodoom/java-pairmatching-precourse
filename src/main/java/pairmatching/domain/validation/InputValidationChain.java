package pairmatching.domain.validation;

import pairmatching.domain.pair.dto.InputValidationRequest;
import pairmatching.domain.pair.dto.InputValidationResponse;

public interface InputValidationChain {

    void setNext(InputValidationChain next);

    InputValidationResponse validate(InputValidationRequest request);
}
