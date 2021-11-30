package com.epamjwd.task5.parser.impl;

import com.epamjwd.task5.entity.Car;
import com.epamjwd.task5.factory.CarFactory;
import com.epamjwd.task5.parser.CarParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarParserImpl implements CarParser {
    private static final String PARAMETER_DELIMITER = " ";
    private static final int WEIGHT = 0;
    private static final int SQUARE = 1;

    @Override
    public List<Car> stringsToCarList(List<String> carStrings) {
        List<Car> carList = new ArrayList<>();
        CarFactory carFactory = CarFactory.getInstance();
        for (String carString : carStrings) {
            String[] parameters = carString.split(PARAMETER_DELIMITER);
            int weight = Integer.parseInt(parameters[WEIGHT]);
            int square = Integer.parseInt(parameters[SQUARE]);
            Optional<Car> optionalCar = carFactory.createCar(weight, square);
            optionalCar.ifPresent(carList::add);
        }
        return carList;
    }
}
