package racingcar.domain;

public class Car {
    private String name;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void validateName(String name){
        if (name.length()>4){
            throw new IllegalArgumentException();
        }
    }
}
