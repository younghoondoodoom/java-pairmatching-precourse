package pairmatching.common.input;


import pairmatching.domain.pair.validation.InputValidationChain;

public interface InputStrategy<T> {

    T executeInput(InputValidationChain validator) throws IllegalArgumentException;
}
