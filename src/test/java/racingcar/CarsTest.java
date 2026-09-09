package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp(){
        cars = new Cars(List.of(
                new Car("자동차1"),
                new Car("자동차2"),
                new Car("자동차3")
        ));
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

}
