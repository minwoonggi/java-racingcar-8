package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("입력값 검증 테스트")
public class InputViewValidatorTest {
    @Nested
    class 자동차_이름_입력값_검증{
        @Test
        void 비어있는_자동차_이름_입력값() {
            List<String> names = List.of("pobi", "woni", " ");

            assertThatThrownBy(() -> InputViewValidator.validateCarNameInput(names))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("비어있는 입력값이 존재합니다.");
        }

        @Test
        void 중복된_자동차_이름_입력값() {
            List<String> names = List.of("pobi", "woni", "pobi");

            assertThatThrownBy(() -> InputViewValidator.validateCarNameInput(names))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("중복된 입력값이 존재합니다.");
        }
    }

    @Nested
    class 시도할_횟수_검증 {
        @Test
        void 정수가_아닌_입력값() {
            String input = "문자";

            assertThatThrownBy(() -> InputViewValidator.validateAttemptCount(input))
                    .isExactlyInstanceOf(IllegalArgumentException.class)
                    .hasMessage("정수값을 입력받아야 합니다.");
        }

        @Test
        void 음수_입력값() {
            String input = "-1";

            assertThatThrownBy(() -> InputViewValidator.validateAttemptCount(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("0보다 큰값을 입력받아야 합니다.");
        }
    }
}
