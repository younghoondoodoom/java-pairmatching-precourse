package pairmatching.common.option;

public class OptionContext {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public <T> void workWithOptionStrategy(OptionStrategy<T> optionStrategy) {
        T result = null;
        while (result == null) {
            try {
                result = optionStrategy.executeOption();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }
}
