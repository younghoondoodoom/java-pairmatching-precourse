package pairmatching.common.option;

import java.io.IOException;

public interface OptionStrategy<T> {

    T executeOption() throws IllegalArgumentException;
}
