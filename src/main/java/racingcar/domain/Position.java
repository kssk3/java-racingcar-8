package racingcar.domain;

import java.util.Objects;

public class Position {

    private static final int DEFAULT_POSITION = 0;
    private int value;

    private Position(int value) {
        this.value = value;
    }

    public static Position initial() {
        return new Position(DEFAULT_POSITION);
    }

    public Position move() {
        return new Position(value + 1);
    }

    public boolean isGreaterThan(Position other) {
        return value > other.value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
