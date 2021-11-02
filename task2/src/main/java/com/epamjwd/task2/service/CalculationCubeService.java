package com.epamjwd.task2.service;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.entity.Point;

public interface CalculationCubeService {
    Double surfaceArea(Cube cube);
    Double volume(Cube cube);
    Double volumeRatio(Cube cube, Point secantPlanePoint);
}
