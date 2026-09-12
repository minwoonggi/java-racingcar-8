package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Cars {
    private static final int MOVE_STANDARD_VALUE = 4;

    private List<Car> cars;
    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromInputNames(List<String> names){
        List<Car> newCars = names.stream()
                .map(Car::new)
                .toList();
        return new Cars(newCars);
    }

    public void moveAll(List<Integer> integerList) {
        for(int i = 0; i < cars.size(); i++) {
            if (integerList.get(i) >= MOVE_STANDARD_VALUE){
                cars.get(i).move();
            }
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int getCarsCount() {
        return cars.size();
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int getMaxPosition(){
       return cars.stream()
               .mapToInt(Car::getPosition)
               .max()
               .orElse(0);
    }
}
