package com.epamjwd.task2.service.impl;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.entity.Point;
import com.epamjwd.task2.service.CalculationCubeService;

public class CalculationCubeServiceImpl implements CalculationCubeService {
    @Override
    public Double surfaceArea(Cube cube) {
        Double cubeEdge = cube.getEdgeLength();
        return Math.pow(cubeEdge, 2) * 6;
    }

    @Override
    public Double volume(Cube cube) {
        Double cubeEdge = cube.getEdgeLength();
        return Math.pow(cubeEdge, 3);
    }

    @Override
    public Double volumeRatio(Cube cube, Point secantPlanePoint) {
        double planeZPosition = secantPlanePoint.getZ();
        double cubeZBottomPosition = cube.getCenter().getZ() - cube.getEdgeLength() / 2;
        double cubeZTopPosition = cube.getCenter().getZ() + cube.getEdgeLength() / 2;
        if (planeZPosition >= cubeZTopPosition || planeZPosition <= cubeZBottomPosition) {
            return 1.;
        }

        double higherLineSegmentLength = cubeZTopPosition - planeZPosition;
        double lowerSegmentLength = planeZPosition - cubeZBottomPosition;

        return higherLineSegmentLength / lowerSegmentLength;
    }

}
