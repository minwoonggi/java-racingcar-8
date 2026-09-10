package racingcar.service;

import racingcar.domain.Cars;
import racingcar.util.RandomGenerator;

import java.util.List;

public class CarRaceService {

    public void oneCycleCarRace(Cars cars){
        int carCounts = cars.getCars().size();

        List<Integer> randomNums = RandomGenerator.createRandomNums(carCounts);

        cars.moveAll(randomNums);
    }
}
