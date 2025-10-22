package racingcar.domain;

import java.util.List;

public class Game {

    private final List<Car> cars;

    public Game(List<Car> cars) {
        this.cars = cars;
    }

    public void playRounds(int count) {
        for (int i = 0; i < count; i++) {
            playOneRound();
        }
    }

    private void playOneRound() {
        cars.forEach(Car::move);
    }

}
