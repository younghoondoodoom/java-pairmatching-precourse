package pairmatching.domain.pair.dto;


import java.util.List;
import pairmatching.domain.pair.type.ValidationType;

public class InputValidationRequest {

    private final List<ValidationType> validationTypes;
    private final String target;

    public InputValidationRequest(List<ValidationType> validationTypes, String target) {
        this.validationTypes = validationTypes;
        this.target = target;
    }

    public List<ValidationType> getValidationTypes() {
        return validationTypes;
    }

    public String getTarget() {
        return target;
    }
}
