package racingcar.controller;

import racingcar.domain.Game;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final GameService gameService = new GameService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Game game;

    public void run() {
        gameInit();
        saveGameCounting();
        processing();
        gameResult();
    }

    private void gameInit() {
        outputView.printInputInfo();
        readCarNames();
    }

    private void readCarNames() {
        String names = inputView.readLine();
        this.game = gameService.createGameByNames(names);
    }

    private void saveGameCounting() {
        int count = getGameCounting();
        game.saveTotalRound(count);
    }

    private int getGameCounting() {
        outputView.printGameCounting();
        String countString = inputView.readLine();
        return gameService.parseAndGetRounds(countString);
    }

    private void processing() {
        outputView.printGameStatus();

        for (int i = 0; i < game.getRounds(); i++) {
            gameService.moveAllCars();
            outputView.printRoundResult(gameService.getAllCars());
            outputView.printNewLine();
        }
    }

    private void gameResult() {
        outputView.printResult(gameService.createWinnersString());
    }

}
