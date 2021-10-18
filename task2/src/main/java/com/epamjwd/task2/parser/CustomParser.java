package com.epamjwd.task2.parser;

import java.util.List;
import java.util.Optional;

public interface CustomParser {
    Optional<List<Double>> stringToCubeParameters(String str);
}
