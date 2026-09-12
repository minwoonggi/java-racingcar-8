package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {
    static final String WINNERS_DELIMITER = ",";

    public static void printRaceResult(Cars cars){
        for(Car car : cars.getCars()){
            System.out.println(
                    car.getName()+" : "+"-".repeat(car.getPosition())
            );
        }
    }

    public static void printWinners(Cars cars){
        List<String> winnerList = cars.getWinner().stream()
                .map(Car::getName)
                .toList();

        System.out.println(
                "최종 우승자 : " + String.join(WINNERS_DELIMITER, winnerList)
        );
    }
}
