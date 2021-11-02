package com.epamjwd.task2.repository.impl;

import com.epamjwd.task2.entity.Cube;
import com.epamjwd.task2.repository.Specification;
import com.epamjwd.task2.service.impl.CalculationCubeServiceImpl;

public class VolumeSpecification implements Specification {
    private final Double volume;

    public VolumeSpecification(Double volume) {
        this.volume = volume;
    }

    @Override
    public boolean specify(Cube cube) {
        CalculationCubeServiceImpl cubeService = new CalculationCubeServiceImpl();
        double volume = cubeService.volume(cube);
        return this.volume == volume;
    }
}
