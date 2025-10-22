package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MOVING_FORWARD = 4;
    private static final int START_POSITION = 0;

    private final String name;
    private int position;

    public Car(final String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public void move() {
        if (isMovable()) {
            position++;
        }
    }

    private int getMoveCount() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean isMovable() {
        return getMoveCount() >= MOVING_FORWARD;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
