package racingcar.domain;

import java.util.List;

public class RacingGame {

    private static final int DEFAULT_ROUND = 0;

    private final Cars cars;
    private final RacingRound racingRound;
    private int currentRound;

    public RacingGame(Cars cars, RacingRound racingRound) {
        this.cars = cars;
        this.racingRound = racingRound;
        this.currentRound = DEFAULT_ROUND;
    }

    public void playRound() {
        validateNotGameFinished();
        cars.moveAll();
        currentRound++;
    }

    private void validateNotGameFinished() {
        if (isFinished()) {
            throw new IllegalArgumentException("게임이 이미 종료되었습니다.");
        }
    }

    private boolean isFinished() {
        return currentRound >= racingRound.getValue();
    }

    public List<Car> getWinners() {
        validateGameFinished();
        return this.cars.findWinners();
    }

    private void validateGameFinished() {
        if (!isFinished()) {
            throw new IllegalStateException("게임이 종료되지 않았습니다.");
        }
    }

    public Cars getCars() {
        return this.cars;
    }

    public RacingRound getRacingRound() {
        return this.racingRound;
    }

    public int getCurrentRound() {
        return this.currentRound;
    }
}
