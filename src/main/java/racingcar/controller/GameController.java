package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final GameService gameService = new GameService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.init();
        String names = inputView.readLine().trim();
        gameService.CreateCarList(names);
    }
}
