package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public static String inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static String inputAttemptCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public static List<String> parseCarNames(String input){
        return List.of(input.split(",",-1));
    }

    public static void isValidCarNameInput(List<String> names){
        validateEmptyCarName(names);
        validateDuplicateCarName(names);
    }

    public static void isValidAttemptCount(String input){
        try{
            Integer num = validateIntegerAttemptCount(input);
            validatePositiveAttemptCount(num);
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
    private static Integer validateIntegerAttemptCount(String input){
        return Integer.parseInt(input);
    }

    private static void validatePositiveAttemptCount(Integer num){
        if (num<0)
            throw new IllegalArgumentException("0보다 큰값을 입력받아야 합니다.");
    }

}
