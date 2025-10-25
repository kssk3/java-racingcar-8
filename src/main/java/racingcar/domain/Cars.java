package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateNotEmpty(cars);
        this.cars = cars;
    }

    private void validateNotEmpty(List<Car> cars) {
        if (cars == null ||  cars.isEmpty()) {
            throw new IllegalArgumentException("최소 1대 이상의 자동차가 필요합니다.");
        }
    }

    public void moveAll() {
        this.cars.forEach(Car::move);
    }

    public List<Car> findWinners() {
        Position maxPosition = findMaxPosition();
        return this.cars.stream().filter(car -> car.isWinner(maxPosition))
                .toList();
    }

    private Position findMaxPosition() {
        return this.cars.stream().map(Car::getPosition)
                .max(Comparator.comparingInt(Position::getValue))
                .orElse(Position.initial());
    }

    public List<Car> getCars() {
        return cars;
    }

    public int size() {
        return cars.size();
    }
}
