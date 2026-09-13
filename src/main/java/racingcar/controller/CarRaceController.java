package racingcar.controller;

import racingcar.controller.dto.CarResult;
import racingcar.controller.mapper.CarResultMapper;
import racingcar.domain.Cars;
import racingcar.service.CarRaceService;
import racingcar.view.InputView;
import racingcar.view.InputViewValidator;
import racingcar.view.OutputView;

import java.util.List;

public class CarRaceController {
    private final CarRaceService carRaceService;

    public CarRaceController(CarRaceService carRaceService) {
        this.carRaceService = carRaceService;
    }

    public void run() {
        String inputCarNames = InputView.inputCarNames();
        List<String> carNamesList = InputView.parseCarNames(inputCarNames);
        InputViewValidator.validateCarNameInput(carNamesList);

        Cars cars = Cars.fromInputNames(carNamesList);

        String inputAttempt = InputView.inputAttemptCount();
        InputViewValidator.validateAttemptCount(inputAttempt);
        int attempt = Integer.parseInt(inputAttempt);

        for (int i = 0;i < attempt; i++){
            carRaceService.oneCycleCarRace(cars);

            List<CarResult> carResults = CarResultMapper.toCarResults(cars);
            OutputView.printRaceResult(carResults);
        }

        List<String> winnerList = cars.getWinners();
        OutputView.printWinners(winnerList);
    }
}
