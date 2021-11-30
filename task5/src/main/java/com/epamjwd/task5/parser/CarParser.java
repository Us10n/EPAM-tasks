package com.epamjwd.task5.parser;

import com.epamjwd.task5.entity.Car;

import java.util.List;

public interface CarParser {
    List<Car> stringsToCarList(List<String> carStrings);
}
