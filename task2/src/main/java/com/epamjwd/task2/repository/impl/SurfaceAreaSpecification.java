package com.epamjwd.task2.repository.impl;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.repository.Specification;
import com.epamjwd.task2.service.impl.CalculationCubeServiceImpl;

public class SurfaceAreaSpecification implements Specification {
    private final Double surfaceArea;

    public SurfaceAreaSpecification(Double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    @Override
    public boolean specify(Cube cube) {
        CalculationCubeServiceImpl cubeService=new CalculationCubeServiceImpl();
        double surfaceArea= cubeService.surfaceArea(cube);
        return false;
    }
}
