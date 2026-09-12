package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public final class RandomGenerator {
    private static final int START_RANGE = 0;
    private static final int END_RANGE = 9;

    private RandomGenerator() {
    }

    public static Integer createRandomNum() {
          return  Randoms.pickNumberInRange(START_RANGE, END_RANGE);
    }
}
