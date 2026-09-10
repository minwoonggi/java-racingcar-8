package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public final class RandomGenerator {
    private RandomGenerator() {
    }

    public static List<Integer> createRandomNums(int carCounts) {
        List<Integer> randomNums = new ArrayList<>();
        for (int i = 0; i< carCounts; i++){
            randomNums.add(Randoms.pickNumberInRange(0,9));
        }
        return randomNums;
    }
}
