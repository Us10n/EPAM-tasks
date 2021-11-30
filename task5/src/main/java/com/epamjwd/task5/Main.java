package com.epamjwd.task5;

import com.epamjwd.task5.entity.Car;
import com.epamjwd.task5.exception.FileException;
import com.epamjwd.task5.parser.impl.CarParserImpl;
import com.epamjwd.task5.reader.impl.CustomReaderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static final String fileName = "/data/cars.txt";

    public static void main(String[] args) throws FileException {
        logger.info("started");
        CustomReaderImpl reader = new CustomReaderImpl();
        List<String> carStrings = reader.readAll(fileName);
        CarParserImpl carParser = new CarParserImpl();
        List<Car> carList = carParser.stringsToCarList(carStrings);
        for (Car car : carList) {
            new Thread(car).start();
        }

    }
}
