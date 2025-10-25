package racingcar.domain;

import java.util.Objects;

public class Position {

    private static final int DEFAULT_POSITION = 0;
    private int value;

    private Position(int value) {
        if(value < DEFAULT_POSITION) {
            throw new IllegalArgumentException("위치는 0 이상이어야 합니다.");
        }
        this.value = value;
    }

    public static Position initial() {
        return new Position(DEFAULT_POSITION);
    }

    public Position move() {
        return new Position(this.value + 1);
    }

    public boolean isGreaterThan(Position other) {
        return this.value > other.value;
    }

    public int getValue() {
        return this.value;
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
