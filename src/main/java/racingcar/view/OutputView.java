package racingcar.view;


import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public void printInputInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public void printGameCounting() {
        System.out.println("시도할 횟수는 몇 회인가?");
    }

    public void printGameStatus() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    public void printResult(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }

    public void printNewLine() {
        System.out.println();
    }
}
