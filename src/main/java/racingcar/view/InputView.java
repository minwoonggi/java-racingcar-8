package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static List<String> parseCarNames(String input){
        return List.of(input.split(",",-1));
    }

    public static void isValidInput(List<String> names){
        validateEmptyName(names);
        validateDuplicateName(names);
    }

    public static void validateEmptyName(List<String> names){
        if (names.stream().anyMatch(String::isBlank))
            throw new IllegalArgumentException();
    }

    public static void validateDuplicateName(List<String> names){
        long uniqueCount = names.stream()
                .distinct()
                .count();

        if (uniqueCount != names.size())
            throw new IllegalArgumentException();
    }

}
