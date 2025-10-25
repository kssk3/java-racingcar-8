package racingcar.controller;

import java.util.Arrays;
import java.util.List;
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

    }

    private RacingGame initializeGame() {
        List<String> names = inputCarNames();
        int roundCount = inputRoundCount();
        return gameService.CreateGame(names, roundCount);
    }

    private void playGames(RacingGame game) {
        outputView.printGameStatus();

        for(int i = 0; i < game.getRacingRound().getValue(); i++) {
            game.playRound();
            outputView.printRoundResult(game.getCars());
            outputView.printNewLine();
        }
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
        return parseRoundCount(rounds);
    }

    private int parseRoundCount(String rounds) {
        try{
            return Integer.parseInt(rounds);
        }catch (NumberFormatException e){
            throw new NumberFormatException("숫자가 아닌 다른값이 입력되었습니다.");
        }
    }
}
