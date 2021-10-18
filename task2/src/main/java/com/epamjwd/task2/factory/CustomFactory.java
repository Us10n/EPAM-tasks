package com.epamjwd.task2.factory;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.entity.Point;

import java.util.List;
import java.util.Optional;

public class CustomFactory {
    private static CustomFactory instance;
    private static final int centerXCoordinate = 0;
    private static final int centerYCoordinate = 1;
    private static final int centerZCoordinate = 2;
    private static final int edgeLength = 3;

    private CustomFactory() {
    }

    public static CustomFactory getInstance() {
        if (instance == null) {
            instance = new CustomFactory();
        }
        return instance;
    }

    public Optional<Point> createPoint(Double[] args) {
        return args == null ? Optional.empty() : Optional.of(new Point(args));
    }

    public Optional<Cube> createCube(Point center, Double edgeLength) {
        return center == null || edgeLength <= 0 ? Optional.empty() : Optional.of(new Cube(center, edgeLength));
    }

    public Optional<Cube> createCube(List<Double> cubeParameters) {
        if (cubeParameters == null) {
            return Optional.empty();
        }
        Double centerX = cubeParameters.get(centerXCoordinate);
        Double centerY = cubeParameters.get(centerYCoordinate);
        Double centerZ = cubeParameters.get(centerZCoordinate);
        Point center = new Point(centerX, centerY, centerZ);
        Double cubeEdgeLength = cubeParameters.get(edgeLength);
        return Optional.of(new Cube(center, cubeEdgeLength));
    }
}
