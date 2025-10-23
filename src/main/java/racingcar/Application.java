package racingcar;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.controller.GameController;
import racingcar.domain.Car;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();
        gameController.run();
//        System.out.println("실행 결과");
//        for (int i = 0; i < count; i++) {
//            cars.stream().forEach(Car::move);
//            cars.stream().forEach(s -> System.out.println(s.getName() + " : " + s.getStatusPosition()));
//            System.out.println();
//        }

    }
}
