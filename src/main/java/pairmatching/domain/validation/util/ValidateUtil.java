package pairmatching.domain.validation.util;

import java.util.Arrays;

public class ValidateUtil {

    public static boolean isExpectedLetter(final String target, final String ... expectedLetters) {
        return Arrays.asList(expectedLetters).contains(target);
    }
}
