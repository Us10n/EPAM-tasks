package com.epamjwd.task2.parser.impl;

import com.epamjwd.task2.parser.CustomParser;
import com.epamjwd.task2.validator.TextValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomParserImpl implements CustomParser {
    private static CustomParserImpl instance;
    private static final String REGEX_DOUBLE = "-?\\d+\\.(\\d+)?";

    private CustomParserImpl() {
    }

    public static CustomParserImpl getInstance() {
        if (instance == null) {
            instance = new CustomParserImpl();
        }
        return instance;
    }

    public Optional<List<Double>> stringToCubeParameters(String str) {
        if (!TextValidator.getInstance().isLineContainParams(str)) {
            return Optional.empty();
        }
        List<Double> cubeParameters = divideToDoubles(str);


        return Optional.of(cubeParameters);
    }

    private List<Double> divideToDoubles(String str) {
        List<Double> list = new ArrayList();

        Pattern splitPatten = Pattern.compile(REGEX_DOUBLE);
        Matcher matcher = splitPatten.matcher(str);

        while (matcher.find()) {
            String group = matcher.group();
            list.add(Double.parseDouble(group));
        }
        return list;
    }
}

