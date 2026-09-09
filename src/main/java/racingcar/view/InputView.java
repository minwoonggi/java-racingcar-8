package racingcar.view;

import java.util.List;

public class InputView {

    public static List<String> parseCarNames(String input){
        return List.of(input.split(",",-1));
    }

    public static void isValidCarNameInput(List<String> names){
        validateEmptyCarName(names);
        validateDuplicateCarName(names);
    }

    public static void isValidAttemptCount(String input){
        try{
            validateIntegerAttemptCount(input);
            validatePositiveAttemptCount(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("정수값을 입력받아야 합니다.");
        }
    }

    private static void validateEmptyCarName(List<String> names){
        if (names.stream().anyMatch(String::isBlank))
            throw new IllegalArgumentException("비어있는 입력값이 존재합니다.");
    }

    private static void validateDuplicateCarName(List<String> names){
        long uniqueCount = names.stream()
                .distinct()
                .count();

        if (uniqueCount != names.size())
            throw new IllegalArgumentException("중복된 입력값이 존재합니다.");
    }
    private static void validateIntegerAttemptCount(String input){
       Integer.parseInt(input);
    }

    private static void validatePositiveAttemptCount(String input){
        int num = Integer.parseInt(input);
        if (num<0)
            throw new IllegalArgumentException("0보다 큰값을 입력받아야 합니다.");
    }

}
