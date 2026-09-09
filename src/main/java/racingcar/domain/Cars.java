package racingcar.domain;

import java.util.List;

public class Cars {
    private static final int MOVE_STANDARD_VAlUE=4;

    List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }


    public void moveAll(List<Integer> integerList) {
        for(int i = 0; i < cars.size(); i++) {
            if (integerList.get(i)>=MOVE_STANDARD_VAlUE){
                cars.get(i).move();
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinner() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition()==maxPosition)
                .toList();
    }

    private int getMaxPosition(){
       return cars.stream()
               .mapToInt(Car::getPosition)
               .max()
               .orElse(0);
    }
}
