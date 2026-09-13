package racingcar.controller.mapper;

import racingcar.controller.dto.CarResult;
import racingcar.domain.Cars;

import java.util.List;

public final class CarResultMapper {
    private CarResultMapper() {
    }

    public static List<CarResult> toCarResults(Cars cars) {
        return cars.getCars().stream()
                .map(car -> new CarResult(car.getName(), car.getPosition()))
                .toList();
    }
}
