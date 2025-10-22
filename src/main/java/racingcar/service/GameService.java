package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;

public class GameService {

    private static final String DEFAULT_DELIMITER = ",";

    private final Validator validator;

    public GameService() {
        this.validator = new Validator();
    }

    public Game CreateGame(String input) {
        List<Car> cars = new ArrayList<>();

        String[] names = input.split(DEFAULT_DELIMITER);
        for(String name : names) {
            validator.validate(name);
            cars.add(new Car(name));
        }

        return new Game(cars);
    }


}
