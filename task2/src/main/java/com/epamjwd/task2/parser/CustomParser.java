package com.epamjwd.task2.parser;

import com.epamjwd.task2.entity.Point;

import java.util.Optional;

public interface CustomParser {
    Optional<Point[]> stringToPointArray(String str);
}
