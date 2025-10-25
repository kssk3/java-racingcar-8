package racingcar.domain;

import java.util.Objects;

public class RacingRound {

    private static final int MINIMUM_ROUND = 1;

    private int value;

    public RacingRound(int value) {
        validateRound(value);
        this.value = value;
    }

    private void validateRound(int value) {
        if (value < MINIMUM_ROUND) {
            throw new IllegalArgumentException("게임 실행 횟수는 최소 1회 이상부터 가능합니다.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingRound round = (RacingRound) o;
        return value == round.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
