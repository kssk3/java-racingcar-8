package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.RacingGame;

public class RacingGameService {

    private static final String DELIMITER = ",";
    private RacingGame game = new RacingGame();

    public RacingGame createGameByNames(String input) {
        List<String> names = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .toList();

        return game;
    }
}
