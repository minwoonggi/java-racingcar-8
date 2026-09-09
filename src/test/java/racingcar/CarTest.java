package racingcar;

import jdk.jfr.Description;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Nested
    class 자동차_이름_테스트 {
        @Test
        void 자동차_이름_5자_이상_실패() {
            String name = "TestName";

            assertThatThrownBy(() -> new Car(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 자동차_이름_5자_이하_성공() {
            String name = "Name";

            Car car = new Car(name);

            assertThat(car.getName()).isEqualTo("Name");
        }
    }

}
