package racingcar.view;

import racingcar.controller.dto.CarResult;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {
    static final String WINNERS_DELIMITER = ",";
    static final String CAR_DISTANCE_DISPLAY = "-";

    public static void printRaceResult(List<CarResult> carResults) {
        for (CarResult carResult : carResults) {
            System.out.println(
                    carResult.name() + " : " + CAR_DISTANCE_DISPLAY.repeat(carResult.position())
            );
        }
    }

    public static void printWinners(List<String> winnerList) {
        System.out.println(
                "최종 우승자 : " + String.join(WINNERS_DELIMITER, winnerList)
        );
    }
}
