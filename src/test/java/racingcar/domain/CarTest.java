package racingcar.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Nested
    class 자동차_이름_테스트 {
        @Test
        void 자동차_이름_5자_초과_실패() {
            String name = "nameee";

            assertThatThrownBy(() -> new Car(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차의 이름은 5자 이하여야 합니다.");
        }

        @Test
        void 자동차_이름_5자_이하_성공() {
            String name = "namee";

            Car car = new Car(name);

            assertThat(car.getName()).isEqualTo("namee");
        }
    }

    @Test
    void 자동차_전진(){
        Car car = new Car("자동차");
        int carPosition = car.getPosition();

        car.move();

        assertThat(car.getPosition()).isEqualTo(carPosition + 1);
    }
}
