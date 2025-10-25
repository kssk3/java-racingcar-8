package racingcar.view;


import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    public void printInputInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public void printGameCounting() {
        System.out.println("시도할 횟수는 몇 회인가?");
    }

    public void printGameStatus() {
        printNewLine();
        System.out.println("실행 결과");
    }

    public void printRoundResult(Cars cars) {
        for (Car car : cars.getCarList()) {
            System.out.println(car.toString());
        }
    }

    public void printResult(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }

    public void printNewLine() {
        System.out.println();
    }
}
