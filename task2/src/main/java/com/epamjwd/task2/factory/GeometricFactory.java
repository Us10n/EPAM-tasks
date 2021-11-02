package com.epamjwd.task2.factory;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.entity.Point;
import com.epamjwd.task2.observer.impl.CubeObserverImpl;

import java.util.List;
import java.util.Optional;

public class GeometricFactory {
    private static GeometricFactory instance;
    private static final int centerXCoordinate = 0;
    private static final int centerYCoordinate = 1;
    private static final int centerZCoordinate = 2;
    private static final int edgeLength = 3;

    private GeometricFactory() {
    }

    public static GeometricFactory getInstance() {
        if (instance == null) {
            instance = new GeometricFactory();
        }
        return instance;
    }

    public Optional<Point> createPoint(Double[] args) {
        return args == null ? Optional.empty() : Optional.of(new Point(args));
    }

    public Optional<Cube> createCube(Point center, Double edgeLength) {
        if (center == null || edgeLength <= 0) {
            return Optional.empty();
        }

        Cube cube = new Cube(center, edgeLength);
        cube.attach(new CubeObserverImpl());
        return Optional.of(cube);
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
        if(cubeEdgeLength<=0){
            return Optional.empty();
        }

        Cube cube=new Cube(center, cubeEdgeLength);
        cube.attach(new CubeObserverImpl());
        return Optional.of(cube);
    }
}
