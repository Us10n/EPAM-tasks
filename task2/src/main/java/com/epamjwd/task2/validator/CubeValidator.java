package com.epamjwd.task2.validator;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.entity.Point;
import org.apache.commons.math3.util.Precision;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CubeValidator {
    private static CubeValidator instance;
    private static final double epsilon = 0.000001d;

    public static CubeValidator getInstance() {
        if (instance == null) {
            instance = new CubeValidator();
        }
        return instance;
    }

    public boolean isCube(Cube cube) {
        if (cube == null) {
            return false;
        }

        Double edgeAB = distanceBetween(cube.getBottomA(), cube.getBottomB());
        Double edgeAD = distanceBetween(cube.getBottomA(), cube.getBottomD());
        Double edgeAA1 = distanceBetween(cube.getBottomA(), cube.getTopA());
        Double edgeAC = distanceBetween(cube.getBottomA(), cube.getBottomC());
        Double edgeAB1 = distanceBetween(cube.getBottomA(), cube.getTopB());
        Double edgeAD1 = distanceBetween(cube.getBottomA(), cube.getTopD());
        Double edgeAC1 = distanceBetween(cube.getBottomA(), cube.getTopC());
        List<Double> edgesFirst = Arrays.asList(edgeAB, edgeAD, edgeAA1, edgeAC, edgeAB1, edgeAD1, edgeAC1);
        edgesFirst.sort(Comparator.naturalOrder());

        boolean firstValidation= Precision.equals(edgesFirst.get(0),edgesFirst.get(1),epsilon) &&
                Precision.equals(edgesFirst.get(1),edgesFirst.get(2),epsilon) &&
                Precision.equals(edgesFirst.get(0)*Math.sqrt(2),edgesFirst.get(3),epsilon) &&
                Precision.equals(edgesFirst.get(0)*Math.sqrt(2),edgesFirst.get(4),epsilon) &&
                Precision.equals(edgesFirst.get(0)*Math.sqrt(2),edgesFirst.get(5),epsilon) &&
                Precision.equals(edgesFirst.get(0)*Math.sqrt(3),edgesFirst.get(6),epsilon);

        Double edgeC1B1 = distanceBetween(cube.getTopC(), cube.getTopB());
        Double edgeC1D1 = distanceBetween(cube.getTopC(), cube.getTopD());
        Double edgeC1C = distanceBetween(cube.getTopC(), cube.getBottomC());
        Double edgeC1A1 = distanceBetween(cube.getTopC(), cube.getTopA());
        Double edgeC1B = distanceBetween(cube.getTopC(), cube.getBottomB());
        Double edgeC1D = distanceBetween(cube.getTopC(), cube.getBottomD());
        Double edgeC1A = distanceBetween(cube.getTopC(), cube.getBottomA());
        List<Double> edgesSecond = Arrays.asList(edgeC1B1, edgeC1D1, edgeC1C, edgeC1A1, edgeC1B, edgeC1D, edgeC1A);
        edgesSecond.sort(Comparator.naturalOrder());

        boolean secondValidation= Precision.equals(edgesSecond.get(0),edgesSecond.get(1),epsilon) &&
                Precision.equals(edgesSecond.get(1),edgesSecond.get(2),epsilon) &&
                Precision.equals(edgesSecond.get(0)*Math.sqrt(2),edgesSecond.get(3),epsilon) &&
                Precision.equals(edgesSecond.get(0)*Math.sqrt(2),edgesSecond.get(4),epsilon) &&
                Precision.equals(edgesSecond.get(0)*Math.sqrt(2),edgesSecond.get(5),epsilon) &&
                Precision.equals(edgesSecond.get(0)*Math.sqrt(3),edgesSecond.get(6),epsilon);

        return firstValidation && secondValidation;
    }

    private Double distanceBetween(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2) + Math.pow(a.getZ() - b.getZ(), 2));
    }
}
