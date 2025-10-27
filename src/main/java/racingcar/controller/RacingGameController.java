package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingRound;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private static final String DELIMITER = ",";

    private final RacingGameService gameService;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(RacingGameService gameService, InputView inputView, OutputView outputView) {
        this.gameService = gameService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        RacingGame game = initializeGame();
        playGames(game);
        gameResult(game);
    }

    private RacingGame initializeGame() {
        List<String> names = inputCarNames();
        validateCarNames(names);

        int roundCount = inputRoundCount();
        return gameService.CreateGame(names, roundCount);
    }

    private void validateCarNames(List<String> names) {
        gameService.validateCarNames(names);
    }

    private void playGames(RacingGame game) {
        outputView.printGameStatus();

        for(int i = 0; i < game.getRacingRound().getValue(); i++) {
            game.playRound();
            outputView.printRoundResult(game.getCars());
            outputView.printNewLine();
        }
    }

    private void gameResult(RacingGame game) {
        List<String> list = game.getWinners()
                .stream()
                .map(car -> car.getCarName().getName())
                .toList();
        outputView.printResult(list);
    }

    private List<String> inputCarNames() {
        outputView.printInputInfo();
        String names = inputView.readLine();
        return parseCarNames(names);
    }

    private List<String> parseCarNames(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

    private int inputRoundCount() {
        outputView.printGameCounting();
        String rounds = inputView.readLine();
        return gameService.parseRacingRound(rounds);
    }
}
