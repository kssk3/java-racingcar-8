package racingcar.domain;

import java.util.List;

public class Game {

    private static final int DEFAULT_INITIAL_ROUND = 0;

    private Cars cars;
    private int rounds;

    public Game() {
        this.cars = new Cars();
        this.rounds = DEFAULT_INITIAL_ROUND;
    }

    public void addCar(Car car) {
        this.cars.addCar(car);
    }

    public void saveTotalRound(int count) {
        this.rounds = count;
    }

    public int getRounds() {
        return rounds;
    }

    public List<Car> getCarList() {
        return cars.getCars();
    }

    public Cars getCars() {
        return cars;
    }

    public List<Car> findWinners() {
        int maxPosition = getCarList().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return getCarList().stream().filter(car -> car.getPosition() == maxPosition).toList();
    }
}
