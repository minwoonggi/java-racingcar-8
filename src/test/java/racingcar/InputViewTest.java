package racingcar;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        void 마지막_쉼표_이후_값_분리확인(){
            String input = "pobi,woni,";

            List<String> names = InputView.parseCarNames(input);

            assertThat(names).containsExactly("pobi", "woni", "");
        }
    }

    @Nested
    class 입력값_검증{
        @Test
        void 비어있는_입력값(){
            List<String> names = List.of("pobi","woni"," ");

            assertThatThrownBy(() -> InputView.isValidInput(names))
                   .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("비어있는 입력값이 존재합니다.");
        }

        @Test
        void 중복된_입력값(){
            List<String> names = List.of("pobi","woni","pobi");

            assertThatThrownBy(() -> InputView.isValidInput(names))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("중복된 입력값이 존재합니다.");
        }
    }
}
