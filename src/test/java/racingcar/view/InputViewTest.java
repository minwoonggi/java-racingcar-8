package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 입력 및 분리 테스트")
public class InputViewTest {
    @Nested
    class 입력값_분리 {
        @Test
        void 입력값_쉼표기준_분리() {
            String input = "pobi,woni,jun";

            List<String> names = InputView.parseCarNames(input);

            assertThat(names).containsExactly("pobi", "woni", "jun");
        }

        @Test
        void 마지막_쉼표_이후_값_분리확인() {
            String input = "pobi,woni,";

            List<String> names = InputView.parseCarNames(input);

            assertThat(names).containsExactly("pobi", "woni", "");
        }
    }
}
