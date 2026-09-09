package racingcar;

import racingcar.controller.CarRaceController;
import racingcar.service.CarRaceService;

public class Application {
    public static void main(String[] args) {
        CarRaceService carRaceService = new CarRaceService();
        CarRaceController carRaceController = new CarRaceController(carRaceService);

        carRaceController.run();
    }
}
