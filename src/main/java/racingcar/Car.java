package racingcar;


import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int START_POSITION = 0;
    private static final int MOVING_FORWARD = 4;
    private static final int NAMING_LENGTH = 5;
    private static final String EXCEPTION_MESSAGE = "이름은 5자 이하만 가능합니다.";

    private String name;
    private int position;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.position = START_POSITION;
    }

    private int getMoveCount() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void validateNameLength(String name) {
        if (name.length() > NAMING_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    private boolean isMovable() {
        return getMoveCount() >= MOVING_FORWARD;
    }

    public void move() {
        if (isMovable()) {
            position++;
        }
    }

    public String printPosition() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
