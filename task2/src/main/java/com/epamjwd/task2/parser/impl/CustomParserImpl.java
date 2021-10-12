package com.epamjwd.task2.parser.impl;

import com.epamjwd.task2.entity.Point;
import com.epamjwd.task2.factory.CustomFactory;
import com.epamjwd.task2.parser.CustomParser;
import com.epamjwd.task2.validator.TextValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomParserImpl implements CustomParser {
    private static CustomParserImpl instance;
    private static final String REGEX_GROUP = "-?\\d+\\.(\\d+)?(\\s-?\\d+\\.(\\d+)?){2}";

    public static CustomParserImpl getInstance() {
        if (instance == null) {
            instance = new CustomParserImpl();
        }
        return instance;
    }

    public Optional<Point[]> stringToPointArray(String str) {
        if (!TextValidator.getInstance().isTextLineValid(str)) {
            return Optional.empty();
        }

        List<Point> pointList = new ArrayList<>();
        List<String> Coordinates = divideToSubStrings(str);
        for (String pointCoordinate : Coordinates) {
            Scanner scanner = new Scanner(pointCoordinate);
            List<Double> coordinates = new ArrayList<>();

            while (scanner.hasNext()) {
                String coordinate = scanner.next();
                coordinates.add(Double.parseDouble(coordinate));
            }
            Optional<Point> point = CustomFactory.getInstance().createPoint(coordinates.toArray(new Double[0]));
            point.ifPresent(pointList::add);
        }

        return Optional.of(pointList.toArray(new Point[0]));
    }

    private List<String> divideToSubStrings(String str) {
        Scanner scanner = new Scanner(str);
        List<String> list = new ArrayList();

        Pattern splitPatten = Pattern.compile(REGEX_GROUP);
        Matcher matcher = splitPatten.matcher(str);
        while (matcher.find()) {
            list.add(matcher.group());
        }

        return list;
    }
}

