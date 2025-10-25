package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car {

    private final CarName carName;
    private Position position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = Position.initial();
    }

    public void move() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            position = position.move();
        }
    }

    public boolean isWinner(Position maxPosition) {
        return this.position.equals(maxPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }

    @Override
    public String toString() {
        return this.carName.getName() + " : " + "-".repeat(this.position.getValue());
    }
}
