package racingcar;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());
        System.out.println(count + "\n");

        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            cars.stream().forEach(Car::move);
            cars.stream().forEach(s -> System.out.println(s.getName() + " : " + s.getStatusPosition()));
            System.out.println();
        }



    }
}
