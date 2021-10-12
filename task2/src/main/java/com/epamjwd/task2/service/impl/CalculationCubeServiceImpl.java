package com.epamjwd.task2.service.impl;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.entity.Point;
import com.epamjwd.task2.entity.SecantPlane;
import com.epamjwd.task2.service.CalculationCubeService;

public class CalculationCubeServiceImpl implements CalculationCubeService {
    @Override
    public Double surfaceArea(Cube cube) {
        Double edgeAB = distanceBetween(cube.getBottomA(), cube.getBottomB());
        return Math.pow(edgeAB, 2) * 6;
    }

    @Override
    public Double volume(Cube cube) {
        Double edgeAB = distanceBetween(cube.getBottomA(), cube.getBottomB());
        return Math.pow(edgeAB, 3);
    }

    @Override
    public Double volumeRatio(Cube cube, SecantPlane plane) {
        double planeZPosition = plane.getA().getZ();
        double cubeZBottomPosition = cube.getBottomA().getZ();
        double cubeZTopPosition = cube.getTopA().getZ();
        if (planeZPosition >= cubeZTopPosition || planeZPosition <= cubeZBottomPosition) {
            return 1.;
        }

        double higherLineSegmentLength = distanceBetween(plane.getA(), cube.getTopA());
        double lowerSegmentLength = distanceBetween(plane.getA(), cube.getBottomA());

        return higherLineSegmentLength / lowerSegmentLength;
    }

    private Double distanceBetween(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2) + Math.pow(a.getZ() - b.getZ(), 2));
    }

}
