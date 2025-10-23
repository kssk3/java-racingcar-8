package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;

public class GameService {

    private static final String DEFAULT_DELIMITER = ",";
    private Game game = new Game();

    public Game createGameByNames(String input) {
        List<String> names = Arrays.stream(input.split(DEFAULT_DELIMITER))
                .map(String::trim)
                .toList();

        for (String name : names) {
            Validator.validateCarNameInput(name);
            game.addCar(new Car(name));
        }

        return game;
    }

    public int parseAndGetRounds(String input) {
        Validator.validateRoundInput(input);
        return Integer.parseInt(input);
    }

    public void moveAllCars() {
        game.getCars().moveAllCars();
    }

    public List<Car> getAllCars() {
        return game.getCarList();
    }

    public String createWinnersString() {
        List<String> winnerNames = game.findWinners().stream()
                .map(Car::getName)
                .toList();

        return String.join(", ", winnerNames);
    }
}
