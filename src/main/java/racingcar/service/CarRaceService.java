package racingcar.service;

import racingcar.domain.Cars;
import racingcar.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class CarRaceService {
    public void oneCycleCarRace(Cars cars) {
        int carCounts = cars.getCarsCount();
        List<Integer> randomNums = new ArrayList<>();

        createRandomNums(carCounts, randomNums);

        cars.moveAll(randomNums);
    }

    private static void createRandomNums(int carCounts, List<Integer> randomNums) {
        for (int i = 0; i < carCounts; i++) {
            randomNums.add(RandomGenerator.createRandomNum());
        }
    }
}
