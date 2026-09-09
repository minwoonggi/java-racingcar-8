package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp(){
        cars = Cars.fromInputNames(List.of(
                "자동차1",
                "자동차2",
                "자동차3")
        );
    }

    @Test
    void 자동차는_랜덤값_4_이상이면_전진(){
        List<Integer> integerList = List.of(4,3,9);

        cars.moveAll(integerList);

        assertThat(cars.getCars().stream()
                .map(Car::getPosition)
                .toList()
        ).containsExactly(1,0,1);
    }

    @Nested
    class 우승한_자동차_반환 {
        @Test
        void 단독_우승힌_자동차_반환() {
            List<Integer> integerList = List.of(2, 3, 9);
            cars.moveAll(integerList);

            assertThat(cars.getWinner().stream()
                    .map(Car::getName)
                    .toList()
            ).containsExactly("자동차3");
        }

        @Test
        void 공동_우승힌_자동차_반환() {
            List<Integer> integerList = List.of(4, 2, 5);
            cars.moveAll(integerList);

            assertThat(cars.getWinner().stream()
                    .map(Car::getName)
                    .toList()
            ).containsExactly("자동차1","자동차3");
        }
    }
}
