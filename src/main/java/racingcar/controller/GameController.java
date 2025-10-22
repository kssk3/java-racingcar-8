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
        gameStart();
        gameCount();
    }

    private void gameStart() {
        outputView.init();
        readCarNames();
        gameCount();
    }

    private void readCarNames() {
        String names = inputView.readLine().trim();
        this.game = gameService.CreateGame(names);
    }

    private void gameCount() {
        outputView.gameCounting();
        String countString = inputView.readLine();
        int count = Integer.parseInt(countString);
        this.game.playRounds(count);
    }


}
