package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(final Car car) {
        this.cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveAllCars() {
        for (Car car : cars) {
            car.attemptToMove();
        }
    }

}
