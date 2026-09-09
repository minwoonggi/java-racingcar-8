package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.CarRaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarRaceController {
    private final CarRaceService carRaceService;

    public CarRaceController(CarRaceService carRaceService){
        this.carRaceService = carRaceService;
    }


    public void run() {
        String inputCarNames =InputView.inputCarNames();
        List<String> carNamesList = InputView.parseCarNames(inputCarNames);
        InputView.isValidCarNameInput(carNamesList);

        Cars cars = Cars.fromInputNames(carNamesList);

        String inputAttempt = InputView.inputAttemptCount();
        int attempt = InputView.isValidAttemptCount(inputAttempt);

        for (int i =0 ;i<attempt; i++){
            carRaceService.oneCycleCarRace(cars);

            OutputView.printRaceResult(cars);
        }

        OutputView.printWinners(cars);
    }
}
