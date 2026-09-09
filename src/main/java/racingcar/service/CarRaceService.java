package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarRaceService {

    public void oneCycleCarRace(Cars cars){
        int carCounts = cars.getCars().size();

        List<Integer> randomNums = new ArrayList<>();
        for (int i=0;i<carCounts;i++){
           randomNums.add(Randoms.pickNumberInRange(0,9));
        }

        cars.moveAll(randomNums);
    }
}
