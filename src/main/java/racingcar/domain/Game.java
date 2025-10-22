package racingcar.domain;

import java.util.List;

public class Game {

    private final List<Car> cars;
    private int rounds;

    public Game(List<Car> cars) {
        this.cars = cars;
    }

    public void saveRounds(int count) {
        this.rounds = count;
    }



}
