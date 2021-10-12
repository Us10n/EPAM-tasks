package com.epamjwd.task2.factory;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.entity.Point;
import com.epamjwd.task2.entity.SecantPlane;

import java.util.Optional;

public class CustomFactory {
    private static CustomFactory instance;

    public static CustomFactory getInstance() {
        if (instance == null) {
            instance = new CustomFactory();
        }
        return instance;
    }

    public Optional<Point> createPoint(Double[] args) {
        if (args == null) {
            return Optional.empty();
        }
        return Optional.of(new Point(args));
    }

    public Optional<Cube> createCube(Point[] args) {
        if (args == null) {
            return Optional.empty();
        }
        return Optional.of(new Cube(args));
    }

    public Optional<SecantPlane> createSecantPlane(Point[] args){
        if (args == null) {
            return Optional.empty();
        }
        return Optional.of(new SecantPlane(args));
    }
}
