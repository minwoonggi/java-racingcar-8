package racingcar.view;

import java.util.List;

public final class InputViewValidator {
    private InputViewValidator() {
    }

    public static void validateCarNameInput(List<String> names) {
        validateEmptyCarName(names);
        validateDuplicateCarName(names);
    }

    public static void validateAttemptCount(String input) {
        try {
            Integer num = validateIntegerAttemptCount(input);
            validatePositiveAttemptCount(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수값을 입력받아야 합니다.");
        }
    }

    private static void validateEmptyCarName(List<String> names) {
        if (names.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException("비어있는 입력값이 존재합니다.");
        }
    }

    private static void validateDuplicateCarName(List<String> names) {
        long uniqueCount = names.stream()
                .distinct()
                .count();

        if (uniqueCount != names.size()) {
            throw new IllegalArgumentException("중복된 입력값이 존재합니다.");
        }
    }
    private static Integer validateIntegerAttemptCount(String input) {
        return Integer.parseInt(input);
    }

    private static void validatePositiveAttemptCount(Integer num) {
        if (num < 0) {
            throw new IllegalArgumentException("0보다 큰값을 입력받아야 합니다.");
        }
    }
}
