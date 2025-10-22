package racingcar.service;

public class Validator {

    private static final String NAMING_EXCEPTION = "이름은 5자 이하만 가능합니다";
    private static final int NAMING_LENGTH = 5;

    public void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
        validateNameLength(input);

    }

    private void validateNameLength(String name) {
        if (name.length() > NAMING_LENGTH) {
            throw new IllegalArgumentException(NAMING_EXCEPTION);
        }
    }
}
