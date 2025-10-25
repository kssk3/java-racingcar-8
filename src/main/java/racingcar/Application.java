package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGameController gameController = new RacingGameController(new RacingGameService(), new InputView(), new OutputView());
        gameController.run();
    }
}
