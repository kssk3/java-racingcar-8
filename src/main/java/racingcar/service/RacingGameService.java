package racingcar.service;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarNameValidator;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingRound;

public class RacingGameService {

    private final CarNameValidator carNameValidator = new CarNameValidator();

    public RacingGame CreateGame(List<String> names, int rounds) {

        List<Car> cars = names.stream()
                .map(CarName::new)
                .map(Car::new)
                .toList();

        return new RacingGame(new Cars(cars), new RacingRound(rounds));
    }

    public int parseRacingRound(String input) {
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException exception){
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }


}
