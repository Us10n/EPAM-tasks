package com.epamjwd.task5.factory;

import com.epamjwd.task5.entity.Car;
import com.epamjwd.task5.entity.CarState;

import java.util.Optional;

public class CarFactory {
    private static CarFactory instance;

    public static CarFactory getInstance() {
        if (instance == null) {
            instance = new CarFactory();
        }
        return instance;
    }

    public Optional<Car> createCar(Integer weight, Integer square) {
        if (weight == null || square == null) {
            return Optional.empty();
        }
        return Optional.of(new Car(weight, square, CarState.WAITING));
    }
}
