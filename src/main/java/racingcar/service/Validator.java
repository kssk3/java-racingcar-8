package racingcar.service;

public class Validator {

    private static final String NAMING_EXCEPTION = "이름은 5자 이하만 가능합니다";
    private static final String NUMBER_EXCEPTION = "숫자가 아닌 다른값이 입력되었습니다.";
    private static final String MINIMUM_EXCEPTION = "게임 실행 횟수는 최소 1 이상부터 가능합니다.";
    private static final int NAMING_LENGTH = 5;
    private static final int MIN_COUNT = 0;

    public static void validateCarNameInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
        validateNameLength(input);
    }

    private static void validateNameLength(String name) {
        if (name.length() > NAMING_LENGTH) {
            throw new IllegalArgumentException(NAMING_EXCEPTION);
        }
    }

    public static void validateRoundInput(String input) {
        try{
            validatePositiveNumber(Integer.parseInt(input));
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(NUMBER_EXCEPTION);
        }
    }

    private static void validatePositiveNumber(int number) {
        if(number <=  MIN_COUNT) {
            throw new IllegalArgumentException(MINIMUM_EXCEPTION);
        }
    }
}
