package racingcar.controller;

import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private Game game = new Game();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void run() {
        outputView.init();
        String names = inputView.readLine();
    }
}
